package feature.auth.data.response

import kotlinx.serialization.Serializable
import user.data.model.UserResponse

@Serializable
data class SignInResponse(
    val user: UserResponse,
    val token: String
)
