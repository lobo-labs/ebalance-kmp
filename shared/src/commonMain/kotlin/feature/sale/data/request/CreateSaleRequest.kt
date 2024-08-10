package feature.sale.data.request

import br.com.lobolabs.ebalance.backend.entity.sale.data.model.common.SaleType
import kotlinx.serialization.Serializable

@Serializable
data class SaleRequest(
    var companyId: Long,
    val notes: String? = null,
    val customerId: Long? = null,
    val receiverId: Long? = null,
    val items: List<SaleItemRequest>,
    val entryDate: Long,
    val finishDate: Long,
    val receiptImage: String? = null,
//    var isPaid: Boolean,
//    var paymentDate: Long?,
    var subtotal: Double,
    var total: Double,
    var discount: Double,
    var type: SaleType
)
