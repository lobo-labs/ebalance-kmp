package feature.cashin.domain

import feature.company.domain.model.CompanyReferenceModel
import feature.sale.domain.SaleModel

data class CashInModel(
    val id: Long,
    val company: CompanyReferenceModel,
    val sale: SaleModel,
    val value: Double,
    val receiptDate: String,
    val receiptImage: String?
)