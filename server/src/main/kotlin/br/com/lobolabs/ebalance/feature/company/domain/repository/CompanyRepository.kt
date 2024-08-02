package br.com.lobolabs.ebalance.feature.company.domain.repository

import br.com.lobolabs.ebalance.feature.company.CompanyDao
import common.CompanyStatus
import company.data.CompanyRequest

interface CompanyRepository {
    suspend fun create(companyRequest: CompanyRequest): Long
    suspend fun delete(companyId: Long): Boolean
    suspend fun getAll(): List<CompanyDao>
    suspend fun getById(companyId: Long): CompanyDao?
    suspend fun getByIds(companyIds: List<Long>): List<CompanyDao>
    suspend fun getByUser(userId: Long): List<CompanyDao>
    suspend fun updateStatus(companyId: Long, companyStatus: CompanyStatus, statusMessage: String = ""): Boolean
    suspend fun update(companyId: Long, companyRequest: CompanyRequest): Boolean
    suspend fun updatePicture(companyId: Long, picture: ByteArray): Boolean
    suspend fun removePicture(companyId: Long): Boolean
    suspend fun setAutoPay(companyId: Long, enabled: Boolean): Boolean
}
