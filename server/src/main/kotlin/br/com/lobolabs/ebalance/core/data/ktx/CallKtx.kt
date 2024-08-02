package br.com.lobolabs.ebalance.core.data.ktx

import br.com.lobolabs.ebalance.core.data.model.RequestPagination
import br.com.lobolabs.ebalance.core.data.model.RequestPaginationOder
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond

fun ApplicationCall.getPaginationParams(order: RequestPaginationOder): RequestPagination {
    val offset = request.queryParameters["offset"]?.toIntOrNull() ?: 0
    val limit = request.queryParameters["limit"]?.toIntOrNull() ?: 100
    return RequestPagination(offset, limit, order)
}

fun ApplicationCall.getIsActiveParam(): Boolean {
    return request.queryParameters["isActive"]?.toBooleanStrictOrNull() ?: true
}

fun ApplicationCall.getIsCancelledParam(): Boolean {
    return request.queryParameters["isCancelled"]?.toBooleanStrictOrNull() ?: false
}

suspend fun ApplicationCall.sendResponse(
    // firebaseManager: FirebaseManager,
    statusCode: Int,
    response: Any,
    request: Any? = null,
    after: Any? = null,
    before: Any? = null,
    isError: Boolean = true,
) {
    // firebaseManager.sendLog(this, statusCode, response, request, before, after, isError)
    respond(HttpStatusCode.fromValue(statusCode), response)
}
