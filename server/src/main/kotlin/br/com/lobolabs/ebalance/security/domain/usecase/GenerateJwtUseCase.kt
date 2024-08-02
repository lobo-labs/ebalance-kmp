package br.com.lobolabs.ebalance.security.domain.usecase

import br.com.lobolabs.ebalance.core.environment.EnvironmentManager
import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import br.com.lobolabs.ebalance.security.data.model.TokenClaim
import br.com.lobolabs.ebalance.security.data.model.TokenConfig
import br.com.lobolabs.ebalance.security.data.repository.TokenRepository
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface GenerateJwtUseCase {
    suspend fun execute(userDao: UserDao, temporaryToken: Boolean = false): ApiStatus<String>
}

class GenerateJwtUseCaseImpl(
    private val tokenRepository: TokenRepository,
    private val environmentManager: EnvironmentManager
) : GenerateJwtUseCase {
    override suspend fun execute(userDao: UserDao, temporaryToken: Boolean): ApiStatus<String> {
        return try {
            val token = tokenRepository.generate(
                TokenConfig(environmentManager.getTokenConfig()),
                TokenClaim.getInstance(userDao),
                temporaryToken
            )
            ApiStatus.Success(token)
        } catch (t: Throwable) {
            ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.GENERIC_ERROR, t))
        }
    }
}
