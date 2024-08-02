package br.com.lobolabs.ebalance.feature.user.data

import br.com.lobolabs.ebalance.backend.core.util.ktx.matchEmailRegex
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode
import user.data.model.request.UserRequest

object UserValidator {
    fun isValid(request: UserRequest): ApiStatus<String> {

        if (request.cpf.isEmpty()) {
            return ApiStatus.Error(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.BODY_FIELD_USER_CPF_LENGHT_INVALID))
        }

        if (request.cpf.length != 11) {
            return ApiStatus.Error(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.BODY_FIELD_USER_CPF_INVALID))
        }

        if (request.name.isEmpty()) {
            return ApiStatus.Error(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.BODY_FIELD_USER_NAME_INVALID))
        }

        if (request.email.isEmpty() || request.email.matchEmailRegex().not()) {
            return ApiStatus.Error(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.BODY_FIELD_USER_EMAIL_INVALID))
        }

        if (request.phone.length != 10 && request.phone.length != 11) {
            return ApiStatus.Error(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.BODY_FIELD_USER_PHONE_INVALID))
        }

        return ApiStatus.Success("Usuário válido!")
    }
}