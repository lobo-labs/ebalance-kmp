package br.com.lobolabs.ebalance.feature.relation.domain.usecase

import br.com.lobolabs.ebalance.feature.relation.domain.repository.CompanyUserRelationRepository
import feature.relation.data.model.RelationRoleAccess
import feature.relation.data.model.RelationType
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface ValidateCompanyUserRelationUseCase {
    suspend fun execute(userId: Long, companyId: Long, access: RelationRoleAccess): ApiStatus<String>
}

class ValidateCompanyUserRelationUseCaseImpl(
    private val companyUserRelationRepository: CompanyUserRelationRepository
) : ValidateCompanyUserRelationUseCase {
    override suspend fun execute(
        userId: Long,
        companyId: Long,
        access: RelationRoleAccess
    ): ApiStatus<String> {

        val relation = try {
            companyUserRelationRepository.getCompanyUserRelation(userId, companyId) ?: run {
                return ApiStatus.Error(HttpStatusCode.NotFound.value, AppError(AppErrorCode.DATABASE_RELATION_NOT_FOUND))
            }
        } catch (t: Throwable) {
            return ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.GENERIC_ERROR, t))
        }

        val relationType = try {
            RelationType.valueOf(relation.relationType)
        } catch (t: Throwable) {
            return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.PARAMS_RELATION_TYPE_INVALID, t))
        }

        when (access) {

            RelationRoleAccess.COMPANY_ADD -> {
                if (!relationType.manageCompanies.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.COMPANY_DELETE -> {
                if (!relationType.manageCompanies.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.COMPANY_EDIT -> {
                if (!relationType.manageCompanies.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.COMPANY_GET -> {
                if (!relationType.manageCompanies.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.CUSTOMER_ADD -> {
                if (!relationType.manageCustomers.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.CUSTOMER_DELETE -> {
                if (!relationType.manageCustomers.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.CUSTOMER_EDIT -> {
                if (!relationType.manageCustomers.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.CUSTOMER_GET -> {
                if (!relationType.manageCustomers.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.EXPENSE_ADD -> {
                if (!relationType.manageExpenses.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.EXPENSE_DELETE -> {
                if (!relationType.manageExpenses.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.EXPENSE_EDIT -> {
                if (!relationType.manageExpenses.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.EXPENSE_GET -> {
                if (!relationType.manageExpenses.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.FINANCIAL_ADD -> {
                if (!relationType.manageFinancial.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.FINANCIAL_DELETE -> {
                if (!relationType.manageFinancial.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.FINANCIAL_EDIT -> {
                if (!relationType.manageFinancial.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.FINANCIAL_GET -> {
                if (!relationType.manageFinancial.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.FINANCIAL_VIEW -> {
                if (!relationType.manageFinancial.canView) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.PROVIDER_ADD -> {
                if (!relationType.manageProviders.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.PROVIDER_DELETE -> {
                if (!relationType.manageProviders.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.PROVIDER_EDIT -> {
                if (!relationType.manageProviders.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.PROVIDER_GET -> {
                if (!relationType.manageProviders.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.RECEIVER_ADD -> {
                if (!relationType.manageReceivers.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.RECEIVER_DELETE -> {
                if (!relationType.manageReceivers.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.RECEIVER_EDIT -> {
                if (!relationType.manageReceivers.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.RECEIVER_GET -> {
                if (!relationType.manageReceivers.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.SALE_ADD -> {
                if (!relationType.manageSales.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.SALE_DELETE -> {
                if (!relationType.manageSales.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.SALE_EDIT -> {
                if (!relationType.manageSales.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.SALE_GET -> {
                if (!relationType.manageSales.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.SEND_MESSAGE -> {
                // TODO verificar
                if (!relationType.canSendMessages) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.SERVICE_ADD -> {
                if (!relationType.manageServices.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.SERVICE_DELETE -> {
                if (!relationType.manageServices.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.SERVICE_EDIT -> {
                if (!relationType.manageServices.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.SERVICE_GET -> {
                if (!relationType.manageServices.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }

            RelationRoleAccess.USER_ADD -> {
                if (!relationType.manageUsers.canAdd) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.USER_DELETE -> {
                if (!relationType.manageUsers.canDelete) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.USER_EDIT -> {
                if (!relationType.manageUsers.canEdit) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
            RelationRoleAccess.USER_GET -> {
                if (!relationType.manageUsers.canGet) {
                    return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.NOT_GRANT_ACCESS))
                }
            }
        }

        return ApiStatus.Success("Relacionamento válido")
    }
}
