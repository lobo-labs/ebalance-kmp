package feature.service.data.response

import br.com.lobolabs.ebalance.backend.entity.sale.data.model.common.SaleType
import kotlinx.serialization.Serializable

@Serializable
data class Service(
    var id: Long,
    var companyId: Long,
    var name: String,
    var price: Double,
    var type: SaleType,
    var isActive: Boolean
)
