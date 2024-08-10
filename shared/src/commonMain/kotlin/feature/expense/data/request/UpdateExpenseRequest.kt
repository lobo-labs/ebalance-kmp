package feature.expense.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateExpenseRequest(
    var description: String,
    var providerId: Long?,
    var value: Double,
    var entryDate: Long,
    var finishDate: Long,
)
