package br.com.lobolabs.ebalance.feature.user.data.database

import org.ktorm.schema.*

object UserTable : Table<UserDao>("users") {
    val id = long("id").primaryKey().bindTo { it.id }
    val cpf = varchar("cpf").bindTo { it.cpf }
    val name = varchar("name").bindTo { it.name }
    val email = varchar("email").bindTo { it.email }
    val phone = varchar("phone").bindTo { it.phone }
    val password = varchar("password").bindTo { it.password }
    val salt = varchar("salt").bindTo { it.salt }
    val type = varchar("type").bindTo { it.type }
    val isActive = boolean("is_active").bindTo { it.isActive }
    val createdAt = jdbcTimestamp("created_at").bindTo { it.createdAt }
}
