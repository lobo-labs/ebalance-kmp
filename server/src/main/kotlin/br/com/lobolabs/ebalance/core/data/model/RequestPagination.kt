package br.com.lobolabs.ebalance.core.data.model

import kotlinx.serialization.Serializable

@Serializable
class RequestPagination(
    val offset: Int = 0,
    val limit: Int = 100,
    val order: RequestPaginationOder? = RequestPaginationOder.CREATED_DATE_DESC
)

