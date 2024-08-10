package feature.expense.data.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateExpenseRequest(
    var companyId: Long,
    var description: String,
    var providerId: Long?,
    var value: Double,
    var entryDate: Long,
    var finishDate: Long,
//    var isPaid: Boolean,
//    var paymentDate: Long?,
)