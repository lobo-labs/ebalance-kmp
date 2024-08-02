package br.com.lobolabs.ebalance.feature.auth.domain.usecase

import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import br.com.lobolabs.ebalance.security.domain.repository.HashingRepository
import br.com.lobolabs.ebalance.security.data.SaltedHash
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface ValidatePasswordUseCase {
    suspend fun execute(password: String, userDao: UserDao): ApiStatus<String>
}

class ValidatePasswordUseCaseImpl(
    private val hashingRepository: HashingRepository
) : ValidatePasswordUseCase {
    override suspend fun execute(password: String, userDao: UserDao): ApiStatus<String> {
        val hash = SaltedHash(userDao.password, userDao.salt)
        try {
            val isValid = hashingRepository.verify(password, hash)
            if (!isValid) {
                return ApiStatus.Error(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.AUTH_ERROR))
            }
            return ApiStatus.Success("Senha validada com sucesso")
        } catch (t: Throwable) {
            return ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.GENERIC_ERROR, t))
        }
    }
}
