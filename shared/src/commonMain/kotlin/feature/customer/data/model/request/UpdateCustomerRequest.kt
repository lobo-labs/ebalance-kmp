package feature.customer.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateCustomerRequest(
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?,
    var notes: String?
)
