package feature.sale.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateSaleRequest(
    val notes: String? = null,
    val customerId: Long? = null,
    val receiverId: Long? = null,
    val entryDate: Long,
    val finishDate: Long,
    var discount: Double
)
