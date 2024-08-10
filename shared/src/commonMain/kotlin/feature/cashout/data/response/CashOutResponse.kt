package feature.cashout.data.response

import feature.company.data.CompanyReferenceResponse
import feature.expense.data.response.ExpenseResponse
import kotlinx.serialization.Serializable

@Serializable
data class CashOutResponse(
    val id: Long,
    val company: CompanyReferenceResponse,
    val expense: ExpenseResponse,
    val value: Double,
    val receiptDate: String,
    val receiptImage: String?
)
