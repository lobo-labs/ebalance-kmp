package br.com.lobolabs.ebalance.feature.sale

import br.com.lobolabs.ebalance.feature.customer.CustomerTable
import br.com.lobolabs.ebalance.feature.company.CompanyTable
import br.com.lobolabs.ebalance.receiver.ReceiverTable
import org.ktorm.schema.Table
import org.ktorm.schema.double
import org.ktorm.schema.jdbcTimestamp
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object SaleTable : Table<SaleDao>("sales") {
    val id = long("id").primaryKey().bindTo { it.id }
    val importId = varchar("import_id").bindTo { it.importId }

    val companyId = long("company_id").bindTo { it.companyId }.references(CompanyTable) { it.company }
    val company get() = companyId.referenceTable as CompanyTable

    val customerId = long("customer_id").bindTo { it.customerId }.references(CustomerTable) { it.customer }
    val customer get() = customerId.referenceTable as? CustomerTable

    val receiverId = long("receiver_id").bindTo { it.receiverId }.references(ReceiverTable) { it.receiver }
    val receiver get() = receiverId.referenceTable as? ReceiverTable

    val notes = varchar("notes").bindTo { it.notes }

    val subtotal = double("subtotal").bindTo { it.subtotal }
    val discount = double("discount").bindTo { it.discount }
    val total = double("total").bindTo { it.total }
    val cashIn = double("cash_in").bindTo { it.cashIn }

    val entryDate = jdbcTimestamp("entry_date").bindTo { it.entryDate }
    val finishDate = jdbcTimestamp("finish_date").bindTo { it.finishDate }
    val receiptImage = varchar("receipt_image").bindTo { it.receiptImage }
    val paymentDate = jdbcTimestamp("payment_date").bindTo { it.paymentDate }
    val status = varchar("status").bindTo { it.status }
    val type = varchar("type").bindTo { it.type }
    val createdAt = jdbcTimestamp("created_at").bindTo { it.createdAt }
}
