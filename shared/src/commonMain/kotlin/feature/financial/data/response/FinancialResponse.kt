package feature.financial.data.response

import kotlinx.serialization.Serializable

@Serializable
class FinancialResponse(
    var received: Double? = null,
    var toReceive: Double? = null,
    var paid: Double? = null,
    var toPay: Double? = null,
    var inflow: Double? = null,
    var outflow: Double? = null,
    var balance: Double? = null,
    var movements: List<FinancialMovement> = emptyList()
)
