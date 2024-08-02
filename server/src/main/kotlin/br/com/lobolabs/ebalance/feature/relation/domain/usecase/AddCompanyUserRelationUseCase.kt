
package br.com.lobolabs.ebalance.feature.relation.domain.usecase

import br.com.lobolabs.ebalance.feature.relation.data.database.CompanyUserRelationDao
import feature.relation.data.database.CompanyUserRelationDao
import br.com.lobolabs.ebalance.feature.relation.domain.repository.CompanyUserRelationRepository
import feature.relation.data.model.RelationType
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface AddCompanyUserRelationUseCase {
    suspend fun execute(userId: Long, companyId: Long, relationType: RelationType): ApiStatus<CompanyUserRelationDao>
}

class AddCompanyUserRelationUseCaseImpl(
    private val companyUserRelationRepository: CompanyUserRelationRepository
) : AddCompanyUserRelationUseCase {
    override suspend fun execute(
        userId: Long,
        companyId: Long,
        relationType: RelationType
    ): ApiStatus<CompanyUserRelationDao> {
        try {
            companyUserRelationRepository.addCompanyUserRelation(userId, companyId, relationType)
            val relation = companyUserRelationRepository.getCompanyUserRelation(userId, companyId) ?: run {
                return ApiStatus.Error(HttpStatusCode.NotFound.value, AppError(AppErrorCode.DATABASE_RELATION_NOT_FOUND))
            }
            return ApiStatus.Success(relation)
        } catch (t: Throwable) {
            return ApiStatus.Error(
                HttpStatusCode.InternalServerError.value,
                AppError(AppErrorCode.DATABASE_RELATION_NOT_ADDED, t)
            )
        }
    }
}
