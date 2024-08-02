package br.com.lobolabs.ebalance.security.domain.usecase

import br.com.lobolabs.ebalance.security.data.SaltedHash
import br.com.lobolabs.ebalance.security.domain.repository.HashingRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface GenerateHashUseCase {
    suspend fun execute(password: String): ApiStatus<SaltedHash>
}

class GenerateHashUseCaseImpl(
    private val hashingRepository: HashingRepository
) : GenerateHashUseCase {
    override suspend fun execute(password: String): ApiStatus<SaltedHash> {
        return try {
            val hash = hashingRepository.generateSaltedHash(password)
            ApiStatus.Success(hash)
        } catch (t: Throwable) {
            ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.GENERIC_ERROR, t))
        }
    }
}
