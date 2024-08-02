package br.com.lobolabs.ebalance.feature.auth.domain.validator

import br.com.lobolabs.ebalance.backend.core.util.ktx.matchEmailRegex
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import feature.auth.data.request.SignInRequest
import io.ktor.http.HttpStatusCode

object SignInValidator {
    fun isValid(request: SignInRequest): ApiStatus<String> {

        if (!request.email.matchEmailRegex()) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.AUTH_EMAIL_INVALID)
            )
        }

        if (request.password.length < 8) {
            return ApiStatus.Error(
                HttpStatusCode.BadRequest.value,
                AppError(AppErrorCode.AUTH_PASSWORD_INVALID)
            )
        }

        return ApiStatus.Success("Objeto de login valido!")
    }
}