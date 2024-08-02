package feature.auth.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdatePasswordRequest(
    val password: String
)