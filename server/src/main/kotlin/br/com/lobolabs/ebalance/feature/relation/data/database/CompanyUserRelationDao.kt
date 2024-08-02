package br.com.lobolabs.ebalance.feature.relation.data.database

import org.ktorm.entity.Entity
import java.sql.Timestamp

interface CompanyUserRelationDao : Entity<CompanyUserRelationDao> {

    companion object : Entity.Factory<CompanyUserRelationDao>()

    val userId: Long
    val companyId: Long
    val relationType: String
    val createdAt: Timestamp

}