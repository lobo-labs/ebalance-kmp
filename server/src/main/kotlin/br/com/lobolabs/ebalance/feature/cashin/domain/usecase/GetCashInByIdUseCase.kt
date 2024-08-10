package br.com.lobolabs.ebalance.feature.cashin.domain.usecase

import br.com.lobolabs.ebalance.feature.cashin.data.database.CashInDao
import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface GetCashInByIdUseCase {
    suspend fun execute(companyId: Long, saleId: Long, id: Long): ApiStatus<CashInDao>
}

class GetCashInByIdUseCaseImpl(
    private val repository: CashInRepository
) : GetCashInByIdUseCase {
    override suspend fun execute(companyId: Long, saleId: Long, id: Long): ApiStatus<CashInDao> {
        val cashIn = try {
            repository.getById(companyId, saleId, id) ?: run {
                return ApiStatus.Error(
                    HttpStatusCode.NotFound.value,
                    AppError(AppErrorCode.DATABASE_CASH_IN_NOT_FOUND)
                )
            }
        } catch (t: Throwable) {
            return ApiStatus.Error(
                HttpStatusCode.InternalServerError.value,
                AppError(AppErrorCode.GENERIC_ERROR, t)
            )
        }
        return ApiStatus.Success(cashIn)
    }
}