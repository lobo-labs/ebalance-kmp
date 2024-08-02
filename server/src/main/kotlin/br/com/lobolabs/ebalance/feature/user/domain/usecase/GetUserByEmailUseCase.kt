package br.com.lobolabs.ebalance.feature.user.domain.usecase

import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import br.com.lobolabs.ebalance.feature.user.domain.repository.UserRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface GetUserByEmailUseCase {
    suspend fun execute(email: String): ApiStatus<UserDao>
}

class GetUserByEmailUseCaseImpl(
    private val userRepository: UserRepository
) : GetUserByEmailUseCase {
    override suspend fun execute(email: String): ApiStatus<UserDao> {
        return try {
            userRepository.getUserByEmail(email)?.let { user ->
                ApiStatus.Success(user)
            } ?: run {
                ApiStatus.Error(HttpStatusCode.NotFound.value, AppError(AppErrorCode.DATABASE_USER_NOT_FOUND))
            }
        } catch (t: Throwable) {
            ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.GENERIC_ERROR, t))
        }
    }
}
