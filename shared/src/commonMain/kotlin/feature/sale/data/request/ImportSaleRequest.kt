package feature.sale.data.request

import kotlinx.serialization.Serializable

@Serializable
data class ImportSaleRequest(
    var importId: String,
    var companyId: Long,
    val customerId: Long? = null,
    val customerName: String? = null,
    val entryDate: Long,
    val finishDate: Long,
    var isPaid: Boolean,
    var paymentDate: Long?,
    var subtotal: Double,
    var fees: Double,
    var penalty: Double,
    var discount: Double,
    var total: Double,
    val notes: String? = null
) {
//    constructor(companyId: Long, customerId: Long?, customerName: String?, line: CSVRecord) : this(
//        importId = line.getValue(0)!!,
//        companyId = companyId,
//        customerId = customerId,
//        customerName = customerName,
//        entryDate = line.getValue(2)!!.toMilliseconds(),
//        finishDate = line.getValue(3)!!.toMilliseconds(),
//        isPaid = if (line.getValue(10).isNullOrEmpty()) false else true,
//        paymentDate = line.getValue(10)?.toMilliseconds(),
//        subtotal = line.getValue(4).getDoubleValue(),
//        fees = line.getValue(5).getDoubleValue(),
//        penalty = line.getValue(6).getDoubleValue(),
//        discount = line.getValue(7).getDoubleValue(),
//        total = line.getValue(8).getDoubleValue(),
//        notes = line.getValue(11)?.replace("\n\n", "\n") +
//                if (line.getValue(8) != line.getValue(9) && line.getValue(9) != null) {
//                    "\nValor recebido: ${line.getValue(9)}"
//                } else {
//                    ""
//                }
//
//    )
}
