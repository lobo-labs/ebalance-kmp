package cashin.domain

import company.domain.CompanyReference
import sale.domain.Sale

data class CashIn(
    val id: Long,
    val company: CompanyReference,
    val sale: Sale,
    val value: Double,
    val receiptDate: String,
    val receiptImage: String?
)