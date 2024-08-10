package br.com.lobolabs.ebalance.feature.cashin.domain.route


import br.com.lobolabs.ebalance.backend.core.data.model.common.CashInSaleUpdateLog
import br.com.lobolabs.ebalance.backend.core.data.response.SuccessResponse
import br.com.lobolabs.ebalance.backend.core.domain.constants.CallParameters
import br.com.lobolabs.ebalance.backend.core.domain.model.AppError
import br.com.lobolabs.ebalance.backend.core.domain.model.AppErrorCode
import br.com.lobolabs.ebalance.backend.core.util.ktx.getSuccessData
import br.com.lobolabs.ebalance.backend.core.util.ktx.runOnError
import br.com.lobolabs.ebalance.backend.core.util.ktx.sendResponse
import br.com.lobolabs.ebalance.backend.entity.auth.domain.use_case.ValidateJwtUseCase
import br.com.lobolabs.ebalance.backend.entity.cash_in.util.mapToResponse
import br.com.lobolabs.ebalance.backend.entity.company.domain.use_case.ValidateCompanyStatusAndRelationUseCase
import br.com.lobolabs.ebalance.backend.entity.company_user_relation.data.common.RelationRoleAccess
import br.com.lobolabs.ebalance.backend.entity.sale.data.model.common.SaleStatus
import br.com.lobolabs.ebalance.backend.entity.sale.data.model.request.UpdateSaleCashInRequest
import br.com.lobolabs.ebalance.backend.entity.sale.domain.use_case.GetSaleByIdUseCase
import br.com.lobolabs.ebalance.backend.entity.sale.domain.use_case.UpdateSaleCashInUseCase
import br.com.lobolabs.ebalance.backend.entity.sale.util.mapToSale
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.CancelCashInUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.GetCashInByIdUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import org.ktorm.database.Database

fun Route.cancelCashInRoute() {

    val database by inject<Database>()

    // val firebase by inject<FirebaseManager>()

    val getCashInByIdUseCase by inject<GetCashInByIdUseCase>()
    val updateSaleCashInUseCase by inject<UpdateSaleCashInUseCase>()

    val getSaleByIdUseCase by inject<GetSaleByIdUseCase>()
    val cancelCashInUseCase by inject<CancelCashInUseCase>()

    val validateCompanyStatusAndRelationUseCase by inject<ValidateCompanyStatusAndRelationUseCase>()

    val validateJwtUseCase by inject<ValidateJwtUseCase>()

    val paramCompanyId = CallParameters.COMPANY_ID
    val paramSaleId = CallParameters.SALE_ID

    put("/api/companies/{$paramCompanyId}/sales/{$paramSaleId}/cash-in/{cashInId}/cancel") {

        val validateJwt = validateJwtUseCase.execute(call)
        validateJwt.runOnError { statusCode, error ->
            call.sendResponse(firebase, statusCode, error)
            return@put
        }
        val jwt = validateJwt.getSuccessData()

        val companyId = call.parameters[paramCompanyId]?.toLongOrNull() ?: run {
            val error = AppError(AppErrorCode.PARAMS_COMPANY_ID_REQUIRED)
            call.sendResponse(firebase, HttpStatusCode.BadRequest, error)
            return@put
        }

        val saleId = call.parameters[paramSaleId]?.toLongOrNull() ?: run {
            val error = AppError(AppErrorCode.PARAMS_SALE_ID_REQUIRED)
            call.sendResponse(firebase, HttpStatusCode.BadRequest, error)
            return@put
        }

        val cashInId = call.parameters["cashInId"]?.toLongOrNull() ?: run {
            val error = AppError(AppErrorCode.PARAMS_RECEIVER_ID_REQUIRED)
            call.sendResponse(firebase, HttpStatusCode.BadRequest, error)
            return@put
        }

        validateCompanyStatusAndRelationUseCase.execute(
            jwt,
            companyId,
            RelationRoleAccess.SALE_EDIT
        ).runOnError { statusCode, error ->
            call.sendResponse(firebase, statusCode, error)
            return@put
        }

        val getSale = getSaleByIdUseCase.execute(companyId, saleId)
        getSale.runOnError { statusCode, error ->
            call.sendResponse(firebase, statusCode, error)
            return@put
        }
        val sale = getSale.getSuccessData()

        if (sale.status == SaleStatus.PAID.toString() || sale.status == SaleStatus.CANCELLED.toString()) {
            val error = AppError(AppErrorCode.CASH_IN_SALE_INVALID)
            call.sendResponse(firebase, HttpStatusCode.BadRequest, error)
            return@put
        }

        val getCashIn = getCashInByIdUseCase.execute(companyId, saleId, cashInId)
        getCashIn.runOnError { statusCode, error ->
            call.sendResponse(firebase, statusCode, error)
            return@put
        }
        val cashIn = getCashIn.getSuccessData()

        database.useTransaction { transaction ->

            val updatedSaleCashIn = sale.cashIn - cashIn.value
            val updateSaleCashInRequest = UpdateSaleCashInRequest(updatedSaleCashIn)

            val updateSaleCashIn = updateSaleCashInUseCase.execute(companyId, saleId, updateSaleCashInRequest)
            updateSaleCashIn.runOnError { statusCode, error ->
                transaction.rollback()
                call.sendResponse(firebase, statusCode, error)
                return@put
            }
            val updatedSale = updateSaleCashIn.getSuccessData()

            val cancelCashIn = cancelCashInUseCase.execute(companyId, saleId, cashInId)
            cancelCashIn.runOnError { statusCode, error ->
                transaction.rollback()
                call.sendResponse(firebase, statusCode, error)
                return@put
            }
            val cancelledCashIn = cancelCashIn.getSuccessData()

            val response = SuccessResponse("Recebimento cancelado com sucesso!")
            call.sendResponse(
                firebase,
                HttpStatusCode.OK,
                response,
                before = CashInSaleUpdateLog(
                    cashIn.mapToResponse(),
                    sale.mapToSale()
                ),
                after = CashInSaleUpdateLog(
                    cancelledCashIn.mapToResponse(),
                    updatedSale.mapToSale()
                ),
                isError = false
            )
        }
    }
}
