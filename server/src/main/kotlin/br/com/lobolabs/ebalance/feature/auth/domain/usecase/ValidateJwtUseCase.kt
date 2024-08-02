package br.com.lobolabs.ebalance.feature.auth.domain.usecase

import br.com.lobolabs.ebalance.security.data.JwtData
import com.auth0.jwt.exceptions.TokenExpiredException
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

interface ValidateJwtUseCase {
    suspend fun execute(call: ApplicationCall): ApiStatus<JwtData>
}

class ValidateJwtUseCaseImpl : ValidateJwtUseCase {
    override suspend fun execute(call: ApplicationCall): ApiStatus<JwtData> {
        call.principal<JWTPrincipal>()?.let { principal ->
            return try {
                val jwt = JwtData(principal)
                ApiStatus.Success(jwt)
            } catch (e: TokenExpiredException) {
                ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.JWT_TOKEN_EXPIRED))
            } catch (e: Exception) {
                ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.JWT_TOKEN_INVALID))
            }
        } ?: run {
            return ApiStatus.Error(HttpStatusCode.Unauthorized.value, AppError(AppErrorCode.JWT_TOKEN_NOT_FOUND))
        }
    }
}
