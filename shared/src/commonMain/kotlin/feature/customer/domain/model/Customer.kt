package feature.customer.domain.model

data class Customer(
    val id: Long,
    val companyId: Long,
    val name: String,
    val cnpj: String?,
    val email: String?,
    val phone: String?,
    val address: String?,
    val notes: String?,
    val isActive: Boolean
)
