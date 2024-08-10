package feature.auth.data.request

import feature.company.data.CreateCompanyRequest
import feature.user.data.request.UserRequest
import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val user: UserRequest,
    val company: CreateCompanyRequest,
    val password: String
)
