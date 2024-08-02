package br.com.lobolabs.ebalance.core.data.ktx

import core.ApiStatus
import core.AppError
import io.ktor.http.HttpStatusCode

inline fun <reified T> ApiStatus<T>.runOnSuccess(
    callback: (data: T) -> Unit
) {
    if (this is ApiStatus.Success) {
        callback(data)
    }
}

inline fun <reified T> ApiStatus<T>.runOnError(
    callback: (statusCode: Int, error: AppError) -> Unit
) {
    if (this is ApiStatus.Error) {
        callback(statusCode, error)
    }
}

inline fun <reified T> ApiStatus<T>.runOnError(
    callback: (error: ApiStatus.Error) -> Unit
) {
    if (this is ApiStatus.Error) {
        callback(this)
    }
}

inline fun <reified T> ApiStatus<T>.getSuccessData(): T {
    val result = this as ApiStatus.Success<T>
    return result.data
}
