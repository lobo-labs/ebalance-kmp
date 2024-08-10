package feature.expense.data.common

import kotlinx.serialization.Serializable

@Serializable
enum class ExpenseStatus {
    UNPAID,
    PAID,
    CANCELLED
}
