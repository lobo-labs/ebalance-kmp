package feature.contract.domain.model

class UpdateContractTaxesModel(
    val fees: Double,
    val penalty: Double,
    val subtotal: Double,
    val total: Double
)