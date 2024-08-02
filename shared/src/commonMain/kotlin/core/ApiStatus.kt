package core

sealed class ApiStatus<out T> {
    data class Success<out T>(val data: T) : ApiStatus<T>()
    data class Error(val statusCode: Int, val error: AppError) : ApiStatus<Nothing>()
}