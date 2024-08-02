package br.com.lobolabs.ebalance.backend.entity.company.data.repository

import br.com.lobolabs.ebalance.feature.company.domain.repository.CompanyRepository
import br.com.lobolabs.ebalance.feature.relation.data.database.CompanyUserRelationTable
import br.com.lobolabs.ebalance.feature.company.CompanyDao
import br.com.lobolabs.ebalance.feature.company.CompanyTable
import common.CompanyStatus
import company.data.CompanyRequest
import org.ktorm.database.Database
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.from
import org.ktorm.dsl.inList
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.select
import org.ktorm.dsl.update
import org.ktorm.dsl.where
import org.ktorm.entity.filter
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class CompanyRepositoryImpl(
    private val database: Database
) : CompanyRepository {

    override suspend fun create(companyRequest: CompanyRequest): Long {
        return database.insertAndGenerateKey(CompanyTable) {
            // set(it.picture, null) TODO check
            set(it.displayName, companyRequest.name)
            set(it.cnpj, companyRequest.data.cnpj)
            set(it.email, companyRequest.data.email)
            set(it.phone, companyRequest.data.phone)
            set(it.companyName, companyRequest.data.companyName)
            set(it.municipalRegistration, companyRequest.data.municipalRegistration)
            set(it.stateRegistration, companyRequest.data.stateRegistration)
            set(it.addressPostalCode, companyRequest.address.postalCode)
            set(it.addressState, companyRequest.address.state)
            set(it.addressCity, companyRequest.address.city)
            set(it.addressStreet, companyRequest.address.street)
            set(it.addressNumber, companyRequest.address.number)
            set(it.addressComplement, companyRequest.address.complement)
            set(it.addressNeighborhood, companyRequest.address.neighborhood)
            set(it.addressLat, companyRequest.address.lat)
            set(it.addressLng, companyRequest.address.lng)
            set(it.cnaeCode, companyRequest.cnae.code)
            set(it.cnaeDescription, companyRequest.cnae.description)
            set(it.regime, companyRequest.taxInfo.regime.toString())
            set(it.specialRegime, companyRequest.taxInfo.specialRegime.toString())
            set(it.internalPrefectureCode, companyRequest.taxInfo.internalPrefectureCode)
            set(it.inssRetention, companyRequest.taxInfo.inssRetention)
            set(it.plan, companyRequest.plan.toString())
            set(it.paymentData, null)
            set(it.autoPayEnabled, false)
            set(it.status, CompanyStatus.PENDING.toString())
        } as Long
    }

    override suspend fun delete(companyId: Long): Boolean {
        return database.delete(CompanyTable) {
            it.id eq companyId
        } > 0
    }

    override suspend fun getById(companyId: Long): CompanyDao? {
        return database.sequenceOf(CompanyTable).filter { company -> company.id eq companyId }.firstOrNull()

    }

    override suspend fun getByIds(companyIds: List<Long>): List<CompanyDao> {
        return database.sequenceOf(CompanyTable).filter { company -> company.id inList companyIds }.toList()
    }

    override suspend fun getByUser(userId: Long): List<CompanyDao> {
        return database.sequenceOf(CompanyTable)
            .filter { company ->
                // TODO ajustar from
                company.id inList (database.from(CompanyUserRelationTable)
                    .select(CompanyUserRelationTable.companyId)
                    .where { CompanyUserRelationTable.userId eq userId })
            }.toList()
    }

    override suspend fun getAll(): List<CompanyDao> {
        return database.sequenceOf(CompanyTable).toList()
    }


    override suspend fun updateStatus(companyId: Long, companyStatus: CompanyStatus, statusMessage: String): Boolean {
        return database.update(CompanyTable) {
            set(it.status, companyStatus.toString())
            set(it.statusMessage, statusMessage)
            where { it.id eq companyId }
        } > 0
    }

    override suspend fun update(companyId: Long, companyRequest: CompanyRequest): Boolean {
        return database.update(CompanyTable) {
            set(it.displayName, companyRequest.name)
            set(it.cnpj, companyRequest.data.cnpj)
            set(it.companyName, companyRequest.data.companyName)
            set(it.municipalRegistration, companyRequest.data.municipalRegistration)
            set(it.stateRegistration, companyRequest.data.stateRegistration)
            set(it.addressPostalCode, companyRequest.address.postalCode)
            set(it.addressState, companyRequest.address.state)
            set(it.addressCity, companyRequest.address.city)
            set(it.addressNumber, companyRequest.address.number)
            set(it.addressComplement, companyRequest.address.complement)
            set(it.addressNeighborhood, companyRequest.address.neighborhood)
            set(it.addressLat, companyRequest.address.lat)
            set(it.addressLng, companyRequest.address.lng)
            set(it.cnaeCode, companyRequest.cnae.code)
            set(it.cnaeDescription, companyRequest.cnae.description)
            set(it.regime, companyRequest.taxInfo.regime.toString())
            set(it.specialRegime, companyRequest.taxInfo.specialRegime.toString())
            set(it.internalPrefectureCode, companyRequest.taxInfo.internalPrefectureCode)
            set(it.inssRetention, companyRequest.taxInfo.inssRetention)
            set(it.plan, companyRequest.plan.toString())
            where { it.id eq companyId }
        } > 0
    }

    override suspend fun updatePicture(companyId: Long, picture: ByteArray): Boolean {
        return database.update(CompanyTable) {
            set(it.picture, picture)
            where { it.id eq companyId }
        } > 0
    }

    override suspend fun removePicture(companyId: Long): Boolean {
        return database.update(CompanyTable) {
            set(it.picture, null)
            where { it.id eq companyId }
        } > 0
    }

    override suspend fun setAutoPay(companyId: Long, enabled: Boolean): Boolean {
        return database.update(CompanyTable) {
            set(it.autoPayEnabled, enabled)
            where { it.id eq companyId }
        } > 0
    }
}
