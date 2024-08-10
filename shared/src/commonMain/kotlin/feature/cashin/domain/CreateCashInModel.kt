package feature.cashin.domain

data class CreateCashInModel(
    val companyId: Long,
    val saleId: Long,
    val value: Double,
    val receiptDate: Long,
    val receiptImage: String?
)
