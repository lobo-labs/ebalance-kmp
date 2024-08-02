package br.com.lobolabs.ebalance.feature.customer

import org.ktorm.entity.Entity
import java.sql.Timestamp

interface CustomerDao : Entity<CustomerDao> {

    companion object : Entity.Factory<CustomerDao>()

    val id: Long
    val importId: String?
    val companyId: Long
    val name: String
    val email: String?
    val phone: String?
    val cnpj: String?
    val address: String?
    val notes: String?
    val isActive: Boolean
    val createdAt: Timestamp
}
