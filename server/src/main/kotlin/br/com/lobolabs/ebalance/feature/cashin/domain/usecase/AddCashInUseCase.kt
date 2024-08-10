package br.com.lobolabs.ebalance.feature.cashin.domain.usecase

import br.com.lobolabs.ebalance.core.data.ktx.getSuccessData
import br.com.lobolabs.ebalance.core.data.ktx.runOnError
import br.com.lobolabs.ebalance.feature.cashin.data.database.CashInDao
import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import feature.cashin.data.request.CreateCashInRequest
import io.ktor.http.HttpStatusCode

interface AddCashInUseCase {
    suspend fun execute(request: CreateCashInRequest): ApiStatus<CashInDao>
}

class AddCashInUseCaseImpl(
    private val repository: CashInRepository,
    private val getCashInByIdUseCase: GetCashInByIdUseCase
): AddCashInUseCase {
    override suspend fun execute(request: CreateCashInRequest): ApiStatus<CashInDao> {
        val cashInId = try {
            repository.create(request)
        } catch (t: Throwable) {
            return  ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.DATABASE_CASH_IN_NOT_ADDED, t))
        }

        val getCashIn = getCashInByIdUseCase.execute(request.companyId, request.saleId, cashInId)
        getCashIn.runOnError {  error -> return error  }
        val cashIn = getCashIn.getSuccessData()

        return ApiStatus.Success(cashIn)
    }
}
