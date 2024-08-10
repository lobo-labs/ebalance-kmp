package feature.sale.data.request

import br.com.lobolabs.ebalance.backend.entity.sale.data.model.common.SaleType
import kotlinx.serialization.Serializable

@Serializable
data class SaleItemRequest(
    var id: Long,
    var name: String,
    var price: Double,
    var quantity: Int,
    var total: Double,
    var type: SaleType
)
