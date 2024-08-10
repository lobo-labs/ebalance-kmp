package br.com.lobolabs.ebalance.feature.cashin.domain

import br.com.lobolabs.ebalance.core.data.model.DateFilter
import br.com.lobolabs.ebalance.feature.cashin.data.database.CashInDao
import feature.cashin.data.request.CreateCashInRequest

interface CashInRepository {
    suspend fun create(request: CreateCashInRequest): Long
    suspend fun cancelBySale(saleId: Long): Boolean
    suspend fun cancel(id: Long): Boolean
    suspend fun cancel(ids: List<Long>): Boolean
    suspend fun delete(id: Long): Boolean
    suspend fun getById(companyId: Long, saleId: Long, id: Long): CashInDao?
    suspend fun getBySale(companyId: Long, saleId: Long, showCancelled: Boolean = false): List<CashInDao>
    suspend fun getByCompany(companyId: Long, filter: DateFilter? = null, showCancelled: Boolean = false): List<CashInDao>
}
