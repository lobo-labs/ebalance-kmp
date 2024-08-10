package feature.financial.data.response

import kotlinx.serialization.Serializable

@Serializable
data class CashInCashOutExportDataResponse(
    var companyName: String,
    var companyCnpj: String,
    var type: String,
    var id: String,
    var customerName: String,
    var description: String,
    var finishDate: String, // data de saida 17-08-2022
    var paymentDate: String, // data de saida 17-08-2022
    var receiptValue: Double,
    var paidValue: Double,
    var fee: Double = 0.0,
    var penalty: Double = 0.0,
    var discount: Double,
    var value: Double,
    var financialAccount: String,
    var category: String,
)
