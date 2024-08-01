package domain.customer

data class Customer(
    val id: Long,
    val cnpj: String?,
    val name: String,
    val email: String,
    val phone: String?,
    val address: String?
)
