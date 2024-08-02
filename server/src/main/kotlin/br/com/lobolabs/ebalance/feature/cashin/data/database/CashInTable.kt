package br.com.lobolabs.ebalance.feature.cashin.data.database

import br.com.lobolabs.ebalance.feature.company.CompanyTable
import br.com.lobolabs.ebalance.feature.sale.SaleTable
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.double
import org.ktorm.schema.jdbcTimestamp
import org.ktorm.schema.long
import org.ktorm.schema.varchar

object CashInTable : Table<CashInDao>("cash_in") {
    val id = long("id").primaryKey().bindTo { it.id }

    val companyId = long("company_id").bindTo { it.companyId }.references(CompanyTable) { it.company }
    val company get() = companyId.referenceTable as CompanyTable

    val saleId = long("sale_id").bindTo { it.saleId }.references(SaleTable) { it.sale }
    val sale get() = saleId.referenceTable as SaleTable

    val value = double("value").bindTo { it.value }
    val receiptDate = jdbcTimestamp("receipt_date").bindTo { it.receiptDate }
    val receiptImage = varchar("receipt_image").bindTo { it.receiptImage }
    val isCancelled = boolean("is_cancelled").bindTo { it.isCancelled }
    val createdAt = jdbcTimestamp("created_at").bindTo { it.createdAt }
}
