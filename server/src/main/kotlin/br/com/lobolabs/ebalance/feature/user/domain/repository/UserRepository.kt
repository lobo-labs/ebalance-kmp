package br.com.lobolabs.ebalance.feature.user.domain.repository

import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import feature.user.data.request.UserRequest

interface UserRepository {
    suspend fun addUser(
        userRequest: UserRequest,
        hash: String,
        salt: String
    ): Long

    suspend fun deleteUser(
        userId: Long
    ): Boolean

    suspend fun getUserByCpf(
        cpf: String
    ): UserDao?

    suspend fun getUserByEmail(
        email: String
    ): UserDao?

    suspend fun getUserById(id: Long): UserDao?
    suspend fun getUsersByCompany(companyId: Long): List<UserDao>
    suspend fun getUsers(): List<UserDao>
    suspend fun searchUserByName(name: String): List<UserDao>
    suspend fun searchUserByEmail(email: String): List<UserDao>
    suspend fun updatePassword(userId: Long, password: String, salt: String): Boolean
    suspend fun update(userId: Long, userRequest: UserRequest): Boolean
}
