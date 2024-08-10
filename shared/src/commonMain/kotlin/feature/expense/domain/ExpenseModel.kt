package feature.expense.domain

import feature.company.domain.model.CompanyReferenceModel

data class ExpenseModel(
    var id: Long,
    var company: CompanyReferenceModel,
    var provider: ProviderReference?,
    var description: String,
    var value: Double,
    var cashOut: Double,
    var toPay: Double,
    var isPaid: Boolean,
    var paymentDate: String?,
    var entryDate: String,
    var finishDate: String,
    var isCancelled: Boolean
)