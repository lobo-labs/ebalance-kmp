package feature.auth.data.request

import company.data.CompanyRequest
import user.data.model.request.UserRequest
import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val user: UserRequest,
    val company: CompanyRequest,
    val password: String
)
