package br.com.lobolabs.ebalance.backend.entity.cash_in.domain.route

import br.com.lobolabs.ebalance.backend.core.domain.constants.CallParameters
import br.com.lobolabs.ebalance.backend.core.domain.firebase.FirebaseManager
import br.com.lobolabs.ebalance.backend.core.domain.model.AppError
import br.com.lobolabs.ebalance.backend.core.domain.model.AppErrorCode
import br.com.lobolabs.ebalance.backend.core.util.ktx.getSuccessData
import br.com.lobolabs.ebalance.backend.core.util.ktx.runOnError
import br.com.lobolabs.ebalance.backend.core.util.ktx.sendResponse
import br.com.lobolabs.ebalance.backend.entity.auth.domain.use_case.ValidateJwtUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.GetCashInByIdUseCase
import br.com.lobolabs.ebalance.backend.entity.cash_in.util.mapToResponse
import br.com.lobolabs.ebalance.backend.entity.company.domain.use_case.ValidateCompanyStatusAndRelationUseCase
import br.com.lobolabs.ebalance.backend.entity.company_user_relation.data.common.RelationRoleAccess
import br.com.lobolabs.ebalance.core.data.ktx.getSuccessData
import br.com.lobolabs.ebalance.core.data.ktx.runOnError
import br.com.lobolabs.ebalance.core.data.ktx.sendResponse
import br.com.lobolabs.ebalance.feature.auth.domain.usecase.ValidateJwtUseCase
import core.AppError
import core.AppErrorCode
import feature.relation.data.model.RelationRoleAccess
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import org.ktorm.database.Database

fun Route.getCashInByIdRoute() {

    val database by inject<Database>()

    // val firebase by inject<FirebaseManager>()

    val getCashInUseCase by inject<GetCashInByIdUseCase>()

    val validateCompanyStatusAndRelationUseCase by inject<ValidateCompanyStatusAndRelationUseCase>()

    val validateJwtUseCase by inject<ValidateJwtUseCase>()

    val paramCompanyId = CallParameters.COMPANY_ID
    val paramSaleId = CallParameters.SALE_ID

    get("/api/companies/{$paramCompanyId}/sales/{$paramSaleId}/cash-in/{cashInId}") {

        val validateJwt = validateJwtUseCase.execute(call)
        validateJwt.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error)
            return@get
        }
        val jwt = validateJwt.getSuccessData()

        val companyId = call.parameters[paramCompanyId]?.toLongOrNull() ?: run {
            val error = AppError(AppErrorCode.PARAMS_COMPANY_ID_REQUIRED)
            call.sendResponse(HttpStatusCode.BadRequest.value, error)
            return@get
        }

        val saleId = call.parameters[paramSaleId]?.toLongOrNull() ?: run {
            val error = AppError(AppErrorCode.PARAMS_SALE_ID_REQUIRED)
            call.sendResponse(HttpStatusCode.BadRequest.value, error)
            return@get
        }

        val cashInId = call.parameters["cashInId"]?.toLongOrNull() ?: run {
            val error = AppError(AppErrorCode.PARAMS_RECEIVER_ID_REQUIRED)
            call.sendResponse(HttpStatusCode.BadRequest.value, error)
            return@get
        }

        // TODO ajustar
        validateCompanyStatusAndRelationUseCase.execute(
            jwt,
            companyId,
            RelationRoleAccess.SALE_GET
        ).runOnError { statusCode, error ->
            call.sendResponse(statusCode, error)
            return@get
        }

        database.useTransaction { transaction ->
            val getCashIn = getCashInUseCase.execute(companyId, saleId, cashInId)
            getCashIn.runOnError { statusCode, error ->
                transaction.rollback()
                call.sendResponse(statusCode, error)
                return@get
            }
            val cashIn = getCashIn.getSuccessData()

            call.sendResponse(
                HttpStatusCode.OK.value,
                cashIn.mapToResponse(),
                isError = false
            )
        }
    }
}

