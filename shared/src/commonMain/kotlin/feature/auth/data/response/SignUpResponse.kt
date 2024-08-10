package feature.auth.data.response

import feature.company.data.CompanyResponse
import kotlinx.serialization.Serializable
import feature.user.data.response.UserResponse

@Serializable
data class SignUpResponse(
    val user: UserResponse,
    val company: CompanyResponse,
    val token: String
)
