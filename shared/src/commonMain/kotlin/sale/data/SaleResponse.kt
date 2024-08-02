package sale.data

import cashin.data.CashInResponse
import company.data.CompanyReferenceResponse
import customer.data.CustomerReferenceResponse
import kotlinx.serialization.Serializable
import receiver.data.ReceiverReferenceResponse

@Serializable
data class SaleResponse(
    val id: Long,
    val company: CompanyReferenceResponse,
    val notes: String?,
    val customer: CustomerReferenceResponse?,
    val receiver: ReceiverReferenceResponse?,
    val items: List<SaleItemResponse>,
    val cashIns: List<CashInResponse>,
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
