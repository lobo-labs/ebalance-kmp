package br.com.lobolabs.ebalance.feature.relation.data.repository

import br.com.lobolabs.ebalance.feature.relation.data.database.CompanyUserRelationDao
import br.com.lobolabs.ebalance.feature.relation.data.database.CompanyUserRelationTable
import br.com.lobolabs.ebalance.feature.relation.domain.repository.CompanyUserRelationRepository
import feature.relation.data.model.RelationType
import org.ktorm.database.Database
import org.ktorm.dsl.and
import org.ktorm.dsl.eq
import org.ktorm.dsl.insert
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf

class CompanyUserRelationRepositoryImpl(
    private val database: Database
) : CompanyUserRelationRepository {

    override suspend fun addCompanyUserRelation(
        userId: Long,
        companyId: Long,
        relationType: RelationType
    ): Boolean {
        return database.insert(CompanyUserRelationTable) {
            set(it.userId, userId)
            set(it.companyId, companyId)
            set(it.relationType, relationType.toString())
        } > 0
    }

    override suspend fun getCompanyUserRelation(
        userId: Long,
        companyId: Long,
    ): CompanyUserRelationDao? {
        return database.sequenceOf(CompanyUserRelationTable)
            .filter { relation -> (relation.userId eq userId) and (relation.companyId eq companyId) }
            .firstOrNull()
    }
}
