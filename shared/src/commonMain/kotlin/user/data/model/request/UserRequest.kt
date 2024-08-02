package user.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    var cpf: String,
    var name: String,
    var email: String,
    var phone: String
)
