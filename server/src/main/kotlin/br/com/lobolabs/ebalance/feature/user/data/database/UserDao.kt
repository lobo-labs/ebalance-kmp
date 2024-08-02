package br.com.lobolabs.ebalance.feature.user.data.database

import org.ktorm.entity.Entity
import java.sql.Timestamp

interface UserDao : Entity<UserDao> {

    companion object : Entity.Factory<UserDao>()

    val id: Long
    val cpf: String
    val name: String
    val email: String
    val phone: String
    val password: String
    val salt: String
    val type: String
    val isActive: Boolean
    val createdAt: Timestamp
}
