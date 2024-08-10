package feature.user.domain.model

data class UserModel(
    var id: Long,
    var cpf: String?,
    var name: String,
    var email: String,
    var phone: String
)
