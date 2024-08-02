package br.com.lobolabs.ebalance.receiver

import org.ktorm.entity.Entity
import java.sql.Timestamp

interface ReceiverDao : Entity<ReceiverDao> {

    companion object : Entity.Factory<ReceiverDao>()

    val id: Long
    val companyId: Long
    val name: String
    val cnpj: String?
    val email: String?
    val phone: String?
    val address: String?
    val isActive: Boolean
    val createdAt: Timestamp
}