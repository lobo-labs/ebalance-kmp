package feature.expense.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateExpenseCashOutRequest(
    val cashOut: Double,
    val markExpenseAsPaid: Boolean = false,
    val cashOutPaymentDate: Long? = null
)
