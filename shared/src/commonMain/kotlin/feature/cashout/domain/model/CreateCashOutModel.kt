package feature.cashout.domain.model

data class CreateCashOutModel(
    val companyId: Long,
    val expenseId: Long,
    val value: Double,
    val receiptDate: Long,
    val receiptImage: String?
)