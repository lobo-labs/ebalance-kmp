package feature.auth.data.response

import company.data.CompanyResponse
import kotlinx.serialization.Serializable
import user.data.model.UserResponse

@Serializable
data class SignUpResponse(
    val user: UserResponse,
    val company: CompanyResponse,
    val token: String
)
