package br.com.lobolabs.ebalance.backend.entity.cash_in.domain.route


import br.com.lobolabs.ebalance.backend.core.data.model.common.CashInSaleUpdateLog
import br.com.lobolabs.ebalance.backend.core.data.response.SuccessResponse
import br.com.lobolabs.ebalance.backend.core.domain.firebase.FirebaseManager
import br.com.lobolabs.ebalance.backend.core.domain.model.AppError
import br.com.lobolabs.ebalance.backend.core.domain.model.AppErrorCode
import br.com.lobolabs.ebalance.backend.core.util.ktx.getSuccessData
import br.com.lobolabs.ebalance.backend.core.util.ktx.runOnError
import br.com.lobolabs.ebalance.backend.core.util.ktx.sendResponse
import br.com.lobolabs.ebalance.backend.entity.auth.domain.use_case.ValidateJwtUseCase
import br.com.lobolabs.ebalance.backend.entity.cash_in.data.model.request.CreateCashInRequest
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.AddCashInUseCase
import br.com.lobolabs.ebalance.backend.entity.cash_in.util.mapToResponse
import br.com.lobolabs.ebalance.backend.entity.company.domain.use_case.ValidateCompanyStatusAndRelationUseCase
import br.com.lobolabs.ebalance.backend.entity.company_user_relation.data.common.RelationRoleAccess
import br.com.lobolabs.ebalance.backend.entity.sale.data.model.request.UpdateSaleCashInRequest
import br.com.lobolabs.ebalance.backend.entity.sale.domain.use_case.GetSaleByIdUseCase
import br.com.lobolabs.ebalance.backend.entity.sale.domain.use_case.UpdateSaleCashInUseCase
import br.com.lobolabs.ebalance.backend.entity.sale.util.canUpdate
import br.com.lobolabs.ebalance.backend.entity.sale.util.mapToSale
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import org.ktorm.database.Database

fun Route.addCashInRoute() {

    val database by inject<Database>()

    val firebase by inject<FirebaseManager>()

    val getSaleByIdUseCase by inject<GetSaleByIdUseCase>()
    val updateSaleCashInUseCase by inject<UpdateSaleCashInUseCase>()
    val addCashInUseCase by inject<AddCashInUseCase>()

    val validateCompanyStatusAndRelationUseCase by inject<ValidateCompanyStatusAndRelationUseCase>()

    val validateJwtUseCase by inject<ValidateJwtUseCase>()

    post("/api/cash-in") {

        val validateJwt = validateJwtUseCase.execute(call)
        validateJwt.runOnError { statusCode, error ->
            call.sendResponse(firebase, statusCode, error)
            return@post
        }
        val jwt = validateJwt.getSuccessData()

        val request = try {
            call.receive<CreateCashInRequest>()
        } catch (t: Throwable) {
            val error = AppError(AppErrorCode.GENERIC_ERROR, t)
            call.sendResponse(firebase, HttpStatusCode.BadRequest, error)
            return@post
        }

        request.isValid().runOnError { statusCode, error ->
            call.sendResponse(firebase, statusCode, error, request)
            return@post
        }

        validateCompanyStatusAndRelationUseCase.execute(
            jwt,
            request.companyId,
            RelationRoleAccess.SALE_EDIT
        ).runOnError { statusCode, error ->
            call.sendResponse(firebase, statusCode, error, request)
            return@post
        }

        val getSale = getSaleByIdUseCase.execute(request.companyId, request.saleId)
        getSale.runOnError { statusCode, error ->
            call.sendResponse(firebase, statusCode, error, request)
            return@post
        }
        val sale = getSale.getSuccessData()

        if (sale.canUpdate().not()) {
            val error = AppError(AppErrorCode.CASH_IN_SALE_INVALID)
            call.sendResponse(firebase, HttpStatusCode.BadRequest, error)
            return@post
        }

        val remainingCashIn = sale.total - sale.cashIn

        if (request.value > remainingCashIn) {
            val error = AppError(AppErrorCode.DATABASE_CASH_IN_BIGGER_THAN_REMAINING)
            call.sendResponse(firebase, HttpStatusCode.BadRequest, error)
            return@post
        }

        val updatedCashIn = sale.cashIn + request.value
        val markSaleAsPaid = request.value == remainingCashIn
        val paymentDate = if (markSaleAsPaid) request.receiptDate else null

        database.useTransaction { transaction ->

            val updateCashInRequest = UpdateSaleCashInRequest(updatedCashIn, markSaleAsPaid, paymentDate)
            val updateCashIn = updateSaleCashInUseCase.execute(request.companyId, request.saleId, updateCashInRequest)
            updateCashIn.runOnError { statusCode, error ->
                transaction.rollback()
                call.sendResponse(firebase, statusCode, error, request)
                return@post
            }
            val updatedSale = updateCashIn.getSuccessData()

            val addCashIn = addCashInUseCase.execute(request)
            addCashIn.runOnError { statusCode, error ->
                transaction.rollback()
                call.sendResponse(firebase, statusCode, error, request)
                return@post
            }
            val cashIn = addCashIn.getSuccessData()

            val response = SuccessResponse("Recebimento criado com sucesso!")
            call.sendResponse(
                firebase,
                HttpStatusCode.OK,
                response,
                request,
                before = CashInSaleUpdateLog(
                    null,
                    sale.mapToSale()
                ),
                after = CashInSaleUpdateLog(
                    cashIn.mapToResponse(),
                    updatedSale.mapToSale()
                ),
                isError = false
            )
        }
    }
}

