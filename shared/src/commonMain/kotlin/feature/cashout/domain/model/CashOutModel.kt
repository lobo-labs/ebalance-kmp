package feature.cashout.domain.model

import feature.company.domain.model.CompanyReferenceModel
import feature.expense.domain.ExpenseModel

data class CashOutModel(
    val id: Long,
    val company: CompanyReferenceModel,
    val expense: ExpenseModel,
    val value: Double,
    val receiptDate: String,
    val receiptImage: String?
)
