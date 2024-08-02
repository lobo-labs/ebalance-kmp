package br.com.lobolabs.ebalance.messaging.data

import kotlinx.serialization.Serializable

@Serializable
data class SendgridRequest(
    val to: String,
    val subject: String,
    val content: String
)
