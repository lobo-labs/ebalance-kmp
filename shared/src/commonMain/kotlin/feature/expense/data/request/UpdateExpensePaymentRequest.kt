package feature.expense.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateExpensePaymentRequest(
    val paymentDate: Long?,
    val isPaid: Boolean
)
