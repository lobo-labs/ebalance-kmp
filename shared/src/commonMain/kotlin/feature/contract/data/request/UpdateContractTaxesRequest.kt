package feature.contract.data.request

import kotlinx.serialization.Serializable

@Serializable
class UpdateContractTaxesRequest(
    val fees: Double,
    val penalty: Double,
    val subtotal: Double,
    val total: Double
)