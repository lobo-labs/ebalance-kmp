package feature.user.data.response

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    var id: Long,
    var cpf: String?,
    var name: String,
    var email: String,
    var phone: String
)
