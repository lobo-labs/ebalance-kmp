package sale.data

import kotlinx.serialization.Serializable

@Serializable
data class SaleItemResponse(
    var id: Long,
    var saleId: Long,
    var itemId: Long,
    var itemName: String,
    var itemPrice: Double,
    var itemQuantity: Int,
    var total: Double
)
