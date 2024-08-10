package feature.contract.data.request
import kotlinx.serialization.Serializable

@Serializable
class FinishContractRequest(
    val endDate: Long,
    val usedDays: Int,
    val totalDays: Double,
    val subtotal: Double,
    val discount: Double,
    val total: Double
)