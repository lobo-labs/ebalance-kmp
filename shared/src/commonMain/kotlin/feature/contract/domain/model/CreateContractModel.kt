package feature.contract.domain.model

import common.CompanyPlans

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
