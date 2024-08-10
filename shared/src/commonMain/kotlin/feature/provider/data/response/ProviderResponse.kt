package feature.provider.data.response

import kotlinx.serialization.Serializable

@Serializable
data class ProviderResponse(
    var id: Long,
    var companyId: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?,
    var address: String?,
    var isActive: Boolean
)
