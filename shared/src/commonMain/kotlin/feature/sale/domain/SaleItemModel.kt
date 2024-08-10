package feature.sale.domain

data class SaleItemModel(
    var id: Long,
    var saleId: Long,
    var itemId: Long,
    var itemName: String,
    var itemPrice: Double,
    var itemQuantity: Int,
    var total: Double
)
