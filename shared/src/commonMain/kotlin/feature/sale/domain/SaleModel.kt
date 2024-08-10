package feature.sale.domain

import feature.cashin.domain.CashInModel
import feature.company.domain.model.CompanyReferenceModel
import feature.customer.domain.model.CustomerReference
import feature.receiver.domain.ReceiverReference

data class SaleModel(
    val id: Long,
    val company: CompanyReferenceModel,
    val notes: String?,
    val customer: CustomerReference?,
    val receiver: ReceiverReference?,
    val items: List<SaleItemModel>,
    val cashIns: List<CashInModel>,
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
