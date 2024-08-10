package feature.auth.data.response

import kotlinx.serialization.Serializable
import feature.user.data.response.UserResponse

@Serializable
data class SignInResponse(
    val user: UserResponse,
    val token: String
)
