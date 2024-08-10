package feature.customer.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CustomerReferenceResponse(
    var id: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?
)