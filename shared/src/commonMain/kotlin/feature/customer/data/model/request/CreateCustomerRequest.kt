package feature.customer.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateCustomerRequest(
    var companyId: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?,
    var address: String?,
    var notes: String?
) 