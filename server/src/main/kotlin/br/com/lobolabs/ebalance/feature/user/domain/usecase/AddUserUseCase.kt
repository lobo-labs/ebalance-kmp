package br.com.lobolabs.ebalance.backend.entity.user.domain.use_case

import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import br.com.lobolabs.ebalance.security.data.SaltedHash
import br.com.lobolabs.ebalance.feature.user.domain.repository.UserRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode
import feature.user.data.request.UserRequest

interface AddUserUseCase {
    suspend fun execute(
        request: UserRequest,
        hash: SaltedHash
    ): ApiStatus<UserDao>
}

class AddUserUseCaseImpl(
    private val userRepository: UserRepository
) : AddUserUseCase {
    override suspend fun execute(
        request: UserRequest,
        hash: SaltedHash
    ): ApiStatus<UserDao> {
        val userId = try {
            userRepository.addUser(request, hash.hash, hash.salt)
        } catch (t: Throwable) {
            return ApiStatus.Error(
                HttpStatusCode.InternalServerError.value,
                AppError(AppErrorCode.DATABASE_USER_NOT_ADDED, t)
            )
        }
        try {
            val userDao = userRepository.getUserById(userId) ?: run {
                return ApiStatus.Error(
                    HttpStatusCode.NotFound.value,
                    AppError(AppErrorCode.DATABASE_USER_NOT_FOUND)
                )
            }
            return ApiStatus.Success(userDao)
        } catch (t: Throwable) {
            return ApiStatus.Error(
                HttpStatusCode.InternalServerError.value,
                AppError(AppErrorCode.DATABASE_USER_NOT_FOUND, t)
            )
        }
    }
}
