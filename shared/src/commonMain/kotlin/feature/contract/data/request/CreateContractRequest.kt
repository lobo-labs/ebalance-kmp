package feature.contract.data.request

import common.CompanyPlans
import kotlinx.serialization.Serializable

@Serializable
class CompanyContractRequest(
    val companyId: Long,
    val previousContractId: Long?,
    val startDate: Long,
    val endDate: Long,
    val plan: CompanyPlans,
    val planPrice: Double,
    val paymentId: String?,
    val refundId: String?,
    val paymentData: String?,
    val paymentDate: Long?,
    val paymentMethod: String,
    val isPaid: Boolean,
    val isActive: Boolean
)