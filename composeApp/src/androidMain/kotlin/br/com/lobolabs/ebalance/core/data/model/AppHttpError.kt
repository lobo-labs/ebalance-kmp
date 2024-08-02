package br.com.lobolabs.ebalance.core.data.model

import core.AppError

sealed interface AppHttpError {
    data class BadRequest(val error: AppError) : AppHttpError
    data class InternalServerError(val error: AppError) : AppHttpError
    data class NotFound(val error: AppError) : AppHttpError
    data class Unauthorized(val error: AppError) : AppHttpError
    data class Forbidden(val error: AppError) : AppHttpError
    data class NotRecognized(val error: AppError) : AppHttpError
}
