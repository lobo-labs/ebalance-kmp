package br.com.lobolabs.ebalance.feature.cashin.domain.usecase

import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface CancelCashInsUseCase {
    suspend fun execute(
        companyId: Long,
        saleId: Long,
        cashInIds: List<Long>
    ): ApiStatus<String>
}

class CancelCashInsUseCaseImpl(
    private val repository: CashInRepository
) : CancelCashInsUseCase {
    override suspend fun execute(
        companyId: Long,
        saleId: Long,
        cashInIds: List<Long>
    ): ApiStatus<String> {

        val cancelled = try {
            repository.cancel(cashInIds)
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

        return ApiStatus.Success("Recebimentos cancelados com sucesso!")
    }
}
