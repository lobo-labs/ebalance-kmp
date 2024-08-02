package br.com.lobolabs.ebalance.core.data.ktx

import core.AppError
import core.AppErrorCode
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException

suspend fun Throwable.getAppError(): AppError {
    runCatching {
        return when (this) {
            is ClientRequestException -> response.body<AppError>()
            else -> AppError(AppErrorCode.GENERIC_ERROR)
        }
    }.getOrElse {
        return AppError(AppErrorCode.GENERIC_ERROR)
    }
}