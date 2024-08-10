package feature.expense.data.response

import kotlinx.serialization.Serializable

@Serializable
class ProviderReferenceResponse(
    var id: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?
)
