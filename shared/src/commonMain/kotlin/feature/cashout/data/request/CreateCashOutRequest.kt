package feature.cashout.data.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateCashOutRequest(
    val companyId: Long,
    val expenseId: Long,
    val value: Double,
    val receiptDate: Long,
    val receiptImage: String?
)