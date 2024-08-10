package br.com.lobolabs.ebalance.feature.cashin.domain.usecase

import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface CancelCashInsBySaleUseCase {
    suspend fun execute(saleId: Long): ApiStatus<String>
}

class CancelCashInsBySaleUseCaseImpl(
    private val repository: CashInRepository
) : CancelCashInsBySaleUseCase {
    override suspend fun execute(saleId: Long): ApiStatus<String> {

        val cancelled = try {
            repository.cancelBySale(saleId)
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
