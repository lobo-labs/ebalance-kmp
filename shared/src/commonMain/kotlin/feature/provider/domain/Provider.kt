package feature.provider.domain

data class Provider(
    val id: Long,
    val name: String,
    val email: String,
    val phone: String?,
    val address: String?
)
