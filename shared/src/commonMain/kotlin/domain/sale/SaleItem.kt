package domain.sale

data class SaleItem(
    var id: Long,
    var saleId: Long,
    var itemId: Long,
    var itemName: String,
    var itemPrice: Double,
    var itemQuantity: Int,
    var total: Double
)
