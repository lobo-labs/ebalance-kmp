package domain.cashin

import domain.company.CompanyReference
import domain.sale.Sale

data class CashIn(
    val id: Long,
    val company: CompanyReference,
    val sale: Sale,
    val value: Double,
    val receiptDate: String,
    val receiptImage: String?
)