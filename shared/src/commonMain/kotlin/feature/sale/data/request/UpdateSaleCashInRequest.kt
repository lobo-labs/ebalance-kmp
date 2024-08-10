package feature.sale.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateSaleCashInRequest(
    val cashIn: Double,
    val markSaleAsPaid: Boolean = false,
    val cashInPaymentDate: Long? = null
)
