package feature.financial.data.common

import kotlinx.serialization.Serializable

@Serializable
enum class FinancialFilter {
    DAY,
    LAST_SEVEN_DAYS,
    LAST_THIRTY_DAYS,
    WEEK,
    MONTH,
    YEAR,
    ALL
}
