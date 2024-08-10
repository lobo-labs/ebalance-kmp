package feature.expense.data.response

import feature.company.data.CompanyReferenceResponse
import kotlinx.serialization.Serializable

@Serializable
data class ExpenseResponse(
    var id: Long,
    var company: CompanyReferenceResponse,
    var provider: ProviderReferenceResponse?,
    var description: String,
    var value: Double,
    var cashOut: Double,
    var toPay: Double,
    var isPaid: Boolean,
    var paymentDate: String?,
    var entryDate: String,
    var finishDate: String,
    var isCancelled: Boolean
)