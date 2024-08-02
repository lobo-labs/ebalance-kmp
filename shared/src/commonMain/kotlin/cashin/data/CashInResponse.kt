package cashin.data

import company.data.CompanyReferenceResponse
import kotlinx.serialization.Serializable
import sale.data.SaleResponse

@Serializable
data class CashInResponse(
    val id: Long,
    val company: CompanyReferenceResponse,
    val sale: SaleResponse,
    val value: Double,
    val receiptDate: String,
    val receiptImage: String?
)
