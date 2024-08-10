package feature.cashin.data.response

import feature.company.data.CompanyReferenceResponse
import kotlinx.serialization.Serializable
import feature.sale.data.response.SaleResponse

@Serializable
data class CashInResponse(
    val id: Long,
    val company: CompanyReferenceResponse,
    val sale: SaleResponse,
    val value: Double,
    val receiptDate: String,
    val receiptImage: String?
)
