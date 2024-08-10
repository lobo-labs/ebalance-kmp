package feature.customer.domain.model

data class UpdateCustomer(
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?,
    var notes: String?
)
