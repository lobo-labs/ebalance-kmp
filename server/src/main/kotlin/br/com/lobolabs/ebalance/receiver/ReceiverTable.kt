package br.com.lobolabs.ebalance.receiver

import org.ktorm.schema.*

object ReceiverTable : Table<ReceiverDao>("receivers") {
    val id = long("id").primaryKey().bindTo { it.id }
    val companyId = long("company_id").bindTo { it.companyId }
    val name = varchar("name").bindTo { it.name }
    val cnpj = varchar("cnpj").bindTo { it.cnpj }
    val email = varchar("email").bindTo { it.email }
    val phone = varchar("phone").bindTo { it.phone }
    val address = varchar("address").bindTo { it.address }
    val isActive = boolean("is_active").bindTo { it.isActive }
    val createdAt = jdbcTimestamp("created_at").bindTo { it.createdAt }
}
