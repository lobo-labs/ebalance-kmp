package sale.domain

import cashin.domain.CashIn
import company.domain.CompanyReference
import customer.domain.CustomerReference
import receiver.domain.ReceiverReference

data class Sale(
    val id: Long,
    val company: CompanyReference,
    val notes: String?,
    val customer: CustomerReference?,
    val receiver: ReceiverReference?,
    val items: List<SaleItem>,
    val cashIns: List<CashIn>,
    val subtotal: Double,
    val discount: Double,
    val total: Double,
    val cashIn: Double,
    val toReceive: Double,
    val entryDate: String,
    val finishDate: String,
    val isLate: Boolean,
    val lateDays: Int,
    val receiptImage: String?,
    val isPaid: Boolean,
    val paymentDate: String,
    val isCancelled: Boolean
)
