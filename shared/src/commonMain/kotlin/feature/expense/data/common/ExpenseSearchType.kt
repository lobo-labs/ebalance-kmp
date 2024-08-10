package feature.expense.data.common

import kotlinx.serialization.Serializable

@Serializable
enum class ExpenseSearchType {
    NONE,
    PROVIDER,
    DESCRIPTION,
    DATE,
    VALUE
}
