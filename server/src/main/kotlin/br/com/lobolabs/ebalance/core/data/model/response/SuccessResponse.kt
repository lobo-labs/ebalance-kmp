package br.com.lobolabs.ebalance.core.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class SuccessResponse(
    val message: String
)