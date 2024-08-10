package feature.financial.data.response

import kotlinx.serialization.Serializable

@Serializable
class FinancialResponseV2(
    var cashIn: Double? = null,
    var cashOut: Double? = null,

    var grossCashIn: Double? = null,
    var grossCashOut: Double? = null,

    var toReceive: Double? = null,
    var toPay: Double? = null,

    var balance: Double? = null,
    var grossBalance: Double? = null,

    var exportData: List<CashInCashOutExportDataResponse> = emptyList()
)
