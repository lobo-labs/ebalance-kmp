package br.com.lobolabs.ebalance.feature.auth.data

import br.com.lobolabs.ebalance.core.data.ktx.runOnError
import br.com.lobolabs.ebalance.feature.company.domain.validator.CompanyValidator
import br.com.lobolabs.ebalance.feature.user.data.UserValidator
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import feature.auth.data.request.SignUpRequest
import io.ktor.http.HttpStatusCode

object SignUpValidator {
    fun isValid(request: SignUpRequest): ApiStatus<String> {

        val validateUser = UserValidator.isValid(request.user)
        validateUser.runOnError { error ->
            return error
        }

        val validateCompany = CompanyValidator.isValid(request.company)
        validateCompany.runOnError { error -> return error }

        if (request.password.length < 8) {
            return ApiStatus.Error(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.AUTH_PASSWORD_INVALID))
        }

        return ApiStatus.Success("Objeto de cadastro valido!")
    }
}