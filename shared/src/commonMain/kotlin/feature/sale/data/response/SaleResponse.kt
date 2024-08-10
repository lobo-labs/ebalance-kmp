package feature.sale.data.response

import feature.cashin.data.response.CashInResponse
import feature.company.data.CompanyReferenceResponse
import feature.customer.data.model.response.CustomerReferenceResponse
import kotlinx.serialization.Serializable
import feature.receiver.data.response.ReceiverReferenceResponse
import feature.sale.data.SaleItemResponse

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
