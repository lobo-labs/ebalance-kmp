package br.com.lobolabs.ebalance.feature.cashin.domain.usecase

import br.com.lobolabs.ebalance.core.data.model.DateFilter
import br.com.lobolabs.ebalance.feature.cashin.data.database.CashInDao
import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface GetCashInsByCompanyUseCase {
    suspend fun execute(
        companyId: Long,
        filter: DateFilter? = null,
        showCancelled: Boolean = false
    ): ApiStatus<List<CashInDao>>
}

class GetCashInsByCompanyUseCaseImpl(
    private val repository: CashInRepository
) : GetCashInsByCompanyUseCase {
    override suspend fun execute(
        companyId: Long,
        filter: DateFilter?,
        showCancelled: Boolean
    ): ApiStatus<List<CashInDao>> {
        val cashIns = try {
            repository.getByCompany(companyId, filter, showCancelled)
        } catch (t: Throwable) {
            return ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.GENERIC_ERROR, t))
        }
        return ApiStatus.Success(cashIns)
    }
}
