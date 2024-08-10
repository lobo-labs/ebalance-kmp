package feature.cashin.data.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateCashInRequest(
    val companyId: Long,
    val saleId: Long,
    val value: Double,
    val receiptDate: Long,
    val receiptImage: String?
)
