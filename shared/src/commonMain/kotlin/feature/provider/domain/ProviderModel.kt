package feature.provider.domain

data class ProviderModel(
    var id: Long,
    var companyId: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?,
    var address: String?,
    var isActive: Boolean
)
