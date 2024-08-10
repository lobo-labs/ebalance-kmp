package br.com.lobolabs.ebalance.feature.cashin.domain.usecase

import br.com.lobolabs.ebalance.core.data.ktx.getSuccessData
import br.com.lobolabs.ebalance.core.data.ktx.runOnError
import br.com.lobolabs.ebalance.feature.cashin.data.database.CashInDao
import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface CancelCashInUseCase {
    suspend fun execute(
        companyId: Long,
        saleId: Long,
        cashInId: Long
    ): ApiStatus<CashInDao>
}

class CancelCashInUseCaseImpl(
    private val repository: CashInRepository,
    private val getCashInByIdUseCase: GetCashInByIdUseCase
) : CancelCashInUseCase {
    override suspend fun execute(
        companyId: Long,
        saleId: Long,
        cashInId: Long
    ): ApiStatus<CashInDao> {

        val cancelled = try {
            repository.cancel(cashInId)
        } catch (t: Throwable) {
            return ApiStatus.Error(
                HttpStatusCode.InternalServerError.value,
                AppError(AppErrorCode.DATABASE_CASH_IN_NOT_UPDATED, t)
            )
        }

        if (cancelled.not()) {
            return ApiStatus.Error(
                HttpStatusCode.InternalServerError.value,
                AppError(AppErrorCode.DATABASE_CASH_IN_NOT_UPDATED)
            )
        }

        val getCashIn = getCashInByIdUseCase.execute(companyId, saleId, cashInId)
        getCashIn.runOnError { error -> return error }
        val cashIn = getCashIn.getSuccessData()

        return ApiStatus.Success(cashIn)
    }
}
