package feature.financial.data.response

import feature.financial.data.common.FinancialType
import kotlinx.serialization.Serializable

@Serializable
class FinancialMovement(
    var value: Double,
    var date: String,
    var type: FinancialType,
    val exportData: ExportData
)
