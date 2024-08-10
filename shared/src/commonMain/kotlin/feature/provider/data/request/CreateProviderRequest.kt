package feature.provider.data.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateProviderRequest(
    var companyId: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?,
    var address: String?
)
