package br.com.lobolabs.ebalance.feature.relation.data.database

import org.ktorm.schema.*

object CompanyUserRelationTable : Table<CompanyUserRelationDao>("company_user_relations") {
    val userId = long("user_id").primaryKey().bindTo { it.userId }
    val companyId = long("company_id").primaryKey().bindTo { it.companyId }
    val relationType = varchar("relation_type").bindTo { it.relationType }
    val createdAt = jdbcTimestamp("created_at").bindTo { it.createdAt }
}
