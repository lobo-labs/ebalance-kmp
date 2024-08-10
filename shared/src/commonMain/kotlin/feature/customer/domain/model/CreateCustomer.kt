package feature.customer.domain.model

data class CreateCustomer(
    var companyId: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?,
    var address: String?,
    var notes: String?
) 