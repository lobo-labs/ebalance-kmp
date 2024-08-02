package customer.domain

data class CustomerReference(
    var id: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?
)