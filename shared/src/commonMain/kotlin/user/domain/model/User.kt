package user.domain.model

data class User(
    var id: Long,
    var cpf: String?,
    var name: String,
    var email: String,
    var phone: String
)
