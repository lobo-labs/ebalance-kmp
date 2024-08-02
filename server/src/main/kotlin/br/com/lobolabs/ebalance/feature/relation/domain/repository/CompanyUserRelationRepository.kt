package br.com.lobolabs.ebalance.feature.relation.domain.repository

import br.com.lobolabs.ebalance.feature.relation.data.database.CompanyUserRelationDao
import feature.relation.data.model.RelationType

interface CompanyUserRelationRepository {
    suspend fun addCompanyUserRelation(
        userId: Long,
        companyId: Long,
        relationType: RelationType
    ): Boolean

    suspend fun getCompanyUserRelation(userId: Long, companyId: Long): CompanyUserRelationDao?
}
