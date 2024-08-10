package feature.contract.domain.model

data class ContractModel(
    val id: Long,
    val companyId: Long,
    val startDate: String,
    val endDate: String,
    val plan: String,
    val planPrice: Double,
    val usedDays: Int,
    val totalDays: Int,
    val fees: Double,
    val penalty: Double,
    val subtotal: Double,
    val discount: Double,
    val total: Double,
    val paymentDate: String?,
    val paymentMethod: String?,
    val isPaid: Boolean,
    val isActive: Boolean,
    val needUpdateTaxes: Boolean
)
