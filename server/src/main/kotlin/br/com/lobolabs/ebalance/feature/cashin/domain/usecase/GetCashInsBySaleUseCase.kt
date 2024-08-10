package br.com.lobolabs.ebalance.feature.cashin.domain.usecase

import br.com.lobolabs.ebalance.feature.cashin.data.database.CashInDao
import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface GetCashInsBySaleUseCase {
    suspend fun execute(
        companyId: Long,
        saleId: Long,
        showCancelled: Boolean = false
    ): ApiStatus<List<CashInDao>>
}

class GetCashInsBySaleUseCaseImpl(
    private val repository: CashInRepository
) : GetCashInsBySaleUseCase {
    override suspend fun execute(
        companyId: Long,
        saleId: Long,
        showCancelled: Boolean
    ): ApiStatus<List<CashInDao>> {
        val cashIns = try {
            repository.getBySale(companyId, saleId, showCancelled)
        } catch (t: Throwable) {
            return ApiStatus.Error(
                HttpStatusCode.InternalServerError.value,
                AppError(AppErrorCode.GENERIC_ERROR, t)
            )
        }
        return ApiStatus.Success(cashIns)
    }
}
