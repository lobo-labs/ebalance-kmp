package br.com.lobolabs.ebalance.feature.sale

import br.com.lobolabs.ebalance.feature.customer.CustomerDao
import br.com.lobolabs.ebalance.feature.company.CompanyDao
import br.com.lobolabs.ebalance.receiver.ReceiverDao
import org.ktorm.entity.Entity
import java.sql.Timestamp

interface SaleDao : Entity<SaleDao> {

    companion object : Entity.Factory<SaleDao>()

    var id: Long
    var importId: String?
    val companyId: Long
    val company: CompanyDao
    var notes: String?
    var customerId: Long?
    var customer: CustomerDao?
    var receiverId: Long?
    var receiver: ReceiverDao?
    var subtotal: Double
    var discount: Double
    var total: Double
    var cashIn: Double
    var entryDate: Timestamp
    var finishDate: Timestamp
    var receiptImage: String?
    var paymentDate: Timestamp?
    var status: String
    var type: String
    var createdAt: Timestamp
}
