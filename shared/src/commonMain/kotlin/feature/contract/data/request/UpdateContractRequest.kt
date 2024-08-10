package feature.contract.data.request
import kotlinx.serialization.Serializable

@Serializable
class UpdateContractRequest(
    val discount: Double,
    val total: Double
)
