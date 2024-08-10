package br.com.lobolabs.ebalance.feature.user.data.repository

import br.com.lobolabs.ebalance.feature.relation.data.database.CompanyUserRelationTable
import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import br.com.lobolabs.ebalance.feature.user.domain.repository.UserRepository
import br.com.lobolabs.ebalance.feature.user.data.database.UserTable
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.support.postgresql.ilike
import feature.user.data.common.UserType
import feature.user.data.request.UserRequest

class UserRepositoryImpl(private val database: Database) : UserRepository {

    override suspend fun addUser(
        userRequest: UserRequest,
        hash: String,
        salt: String
    ): Long {
        return database.insertAndGenerateKey(UserTable) {
            set(UserTable.cpf, userRequest.cpf)
            set(UserTable.name, userRequest.name)
            set(UserTable.email, userRequest.email)
            set(UserTable.phone, userRequest.phone)
            set(UserTable.password, hash)
            set(UserTable.salt, salt)
            set(UserTable.type, UserType.USER.toString())
        } as Long
    }

    override suspend fun deleteUser(userId: Long): Boolean {
        return database.delete(UserTable) { it.id eq userId } > 0
    }

    override suspend fun getUserByCpf(cpf: String): UserDao? {
        return database.from(UserTable)
            .select(UserTable.columns)
            .where { UserTable.cpf eq cpf }
            .map { UserTable.createEntity(it) }
            .firstOrNull()
    }

    override suspend fun getUserByEmail(email: String): UserDao? {
        return database.from(UserTable)
            .select(UserTable.columns)
            .where { UserTable.email eq email }
            .map { UserTable.createEntity(it) }
            .firstOrNull()
    }

    override suspend fun getUserById(id: Long): UserDao? {
        return database.from(UserTable)
            .select(UserTable.columns)
            .where { UserTable.id eq id }
            .map { UserTable.createEntity(it) }
            .firstOrNull()
    }

    override suspend fun getUsersByCompany(companyId: Long): List<UserDao> {
        return database.from(UserTable)
            .select(UserTable.columns)
            .where {
                UserTable.id inList (database.from(CompanyUserRelationTable)
                    .select(CompanyUserRelationTable.userId)
                    .where { CompanyUserRelationTable.companyId eq companyId })
            }
            .map { UserTable.createEntity(it) }
    }

    override suspend fun getUsers(): List<UserDao> {
        return database.from(UserTable)
            .select(UserTable.columns)
            .map { UserTable.createEntity(it) }
    }

    override suspend fun searchUserByName(name: String): List<UserDao> {
        return database.from(UserTable)
            .select(UserTable.columns)
            .where { UserTable.name ilike "%$name%" }
            .map { UserTable.createEntity(it) }
    }

    override suspend fun searchUserByEmail(email: String): List<UserDao> {
        return database.from(UserTable)
            .select(UserTable.columns)
            .where { UserTable.email ilike "%$email%" }
            .map { UserTable.createEntity(it) }
    }

    override suspend fun updatePassword(userId: Long, password: String, salt: String): Boolean {
        return database.update(UserTable) {
            set(UserTable.password, password)
            set(UserTable.salt, salt)
            where { it.id eq userId }
        } > 0
    }

    override suspend fun update(userId: Long, userRequest: UserRequest): Boolean {
        return database.update(UserTable) {
            set(UserTable.email, userRequest.email)
            set(UserTable.name, userRequest.name)
            set(UserTable.phone, userRequest.phone)
            where { it.id eq userId }
        } > 0
    }
}
