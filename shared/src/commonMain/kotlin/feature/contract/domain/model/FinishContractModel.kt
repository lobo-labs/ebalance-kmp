package feature.contract.domain.model

class FinishContractModel(
    val endDate: Long,
    val usedDays: Int,
    val totalDays: Double,
    val subtotal: Double,
    val discount: Double,
    val total: Double
)
