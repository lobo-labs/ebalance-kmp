package br.com.lobolabs.ebalance.feature.cashin.data.database

import br.com.lobolabs.ebalance.feature.company.CompanyDao
import br.com.lobolabs.ebalance.feature.sale.SaleDao
import org.ktorm.entity.Entity
import java.sql.Timestamp

interface CashInDao : Entity<CashInDao> {

    companion object : Entity.Factory<CashInDao>()

    val id: Long
    val companyId: Long
    val company: CompanyDao
    val saleId: Long
    val sale: SaleDao
    val value: Double
    val receiptDate: Timestamp
    val receiptImage: String?
    val isCancelled: Boolean

    val createdAt: Timestamp
}
