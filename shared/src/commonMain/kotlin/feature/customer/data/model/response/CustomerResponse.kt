package feature.customer.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CustomerResponse(
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
