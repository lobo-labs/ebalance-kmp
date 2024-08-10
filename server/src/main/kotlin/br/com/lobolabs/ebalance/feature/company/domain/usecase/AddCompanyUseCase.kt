package br.com.lobolabs.ebalance.feature.company.domain.usecase

import br.com.lobolabs.ebalance.feature.company.CompanyDao
import br.com.lobolabs.ebalance.feature.company.domain.repository.CompanyRepository
import feature.company.data.CreateCompanyRequest
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface AddCompanyUseCase {
    suspend fun execute(request: CreateCompanyRequest): ApiStatus<CompanyDao>
}

class AddCompanyUseCaseImpl(
    private val companyRepository: CompanyRepository
) : AddCompanyUseCase {
    override suspend fun execute(request: CreateCompanyRequest): ApiStatus<CompanyDao> {
        try {
            val companyId = companyRepository.create(request)
            val companyDao = companyRepository.getById(companyId) ?: run {
                return ApiStatus.Error(
                    HttpStatusCode.NotFound.value,
                    AppError(AppErrorCode.DATABASE_USER_NOT_FOUND)
                )
            }
            return ApiStatus.Success(companyDao)
        } catch (t: Throwable) {
            return ApiStatus.Error(
                HttpStatusCode.InternalServerError.value,
                AppError(AppErrorCode.DATABASE_COMPANY_NOT_ADDED, t)
            )
        }
    }
}