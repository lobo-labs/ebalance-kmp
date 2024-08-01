package signin.data.model.response

import user.data.UserResponse

//@Serializable
data class SignInResponse(
    val user: UserResponse,
    val token: String
)
