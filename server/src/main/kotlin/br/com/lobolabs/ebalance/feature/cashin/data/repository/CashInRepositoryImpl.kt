package br.com.lobolabs.ebalance.feature.cashin.data.repository

import br.com.lobolabs.ebalance.core.data.model.DateFilter
import br.com.lobolabs.ebalance.feature.cashin.data.database.CashInDao
import br.com.lobolabs.ebalance.feature.cashin.data.database.CashInTable
import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import br.com.lobolabs.ebalance.feature.sale.SaleTable
import feature.cashin.data.request.CreateCashInRequest
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import java.sql.Timestamp

class CashInRepositoryImpl(
    private val database: Database
) : CashInRepository {
    override suspend fun create(request: CreateCashInRequest): Long {
        return database.insertAndGenerateKey(CashInTable) {
            set(it.companyId, request.companyId)
            set(it.saleId, request.saleId)
            set(it.value, request.value)
            set(it.receiptDate, Timestamp(request.receiptDate))
            set(it.receiptImage, request.receiptImage)
            set(it.isCancelled, false)
        } as Long
    }

    override suspend fun cancelBySale(saleId: Long): Boolean {
        // TODO ajustar
        return database.update(CashInTable) {
            set(it.isCancelled, true)
            where {
                it.saleId inList (database.from(SaleTable))
                    .select(SaleTable.id)
                    .where {
                        SaleTable.id eq saleId
                    }
            }
        } > 0
    }

    override suspend fun cancel(id: Long): Boolean {
        return database.update(CashInTable) { set(it.isCancelled, true) } > 0
    }

    override suspend fun cancel(ids: List<Long>): Boolean {
        return database.update(CashInTable) {
            set(it.isCancelled, true)
            where { it.id inList ids }
        } > 0
    }

    override suspend fun delete(id: Long): Boolean {
        return database.delete(CashInTable) { it.id eq id } > 0
    }

    override suspend fun getById(companyId: Long, saleId: Long, id: Long): CashInDao? {
        return database.sequenceOf(CashInTable)
            .filter { cashIn ->
                (cashIn.companyId eq companyId) and
                        (cashIn.saleId eq saleId) and
                        (cashIn.id eq id)
            }.firstOrNull()
    }

    override suspend fun getBySale(companyId: Long, saleId: Long, showCancelled: Boolean): List<CashInDao> {
        return if (showCancelled) {
            database.sequenceOf(CashInTable)
                .filter { cashIn ->
                    (cashIn.companyId eq companyId) and
                            (cashIn.saleId eq saleId)
                }.toList()
        } else {
            database.sequenceOf(CashInTable)
                .filter { cashIn ->
                    (cashIn.companyId eq companyId) and
                            (cashIn.saleId eq saleId) and
                            (cashIn.isCancelled eq false)
                }.toList()
        }
    }

    override suspend fun getByCompany(companyId: Long, filter: DateFilter?, showCancelled: Boolean): List<CashInDao> {
        return when {
            filter != null && showCancelled.not() -> {
                database.sequenceOf(CashInTable)
                    .filter { cashIn ->
                        (cashIn.companyId eq companyId) and
                                (cashIn.isCancelled eq false) and
                                (cashIn.receiptDate lessEq Timestamp(filter.end)) and
                                (cashIn.receiptDate greaterEq Timestamp(filter.start))
                    }.toList()
            }

            filter != null && showCancelled -> {
                database.sequenceOf(CashInTable)
                    .filter { cashIn ->
                        (cashIn.companyId eq companyId) and
                                (cashIn.receiptDate lessEq Timestamp(filter.end)) and
                                (cashIn.receiptDate greaterEq Timestamp(filter.start))
                    }.toList()
            }

            filter == null && showCancelled.not() -> {
                database.sequenceOf(CashInTable)
                    .filter { cashIn ->
                        (cashIn.companyId eq companyId) and
                                (cashIn.isCancelled eq false)
                    }.toList()
            }

            else -> {
                database.sequenceOf(CashInTable)
                    .filter { cashIn ->
                        cashIn.companyId eq companyId
                    }.toList()
            }
        }
    }
}
