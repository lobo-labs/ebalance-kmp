package br.com.lobolabs.ebalance.feature.company

import org.ktorm.entity.Entity
import java.sql.Timestamp

interface CompanyDao : Entity<CompanyDao> {

    companion object : Entity.Factory<CompanyDao>()

    val id: Long

    val picture: ByteArray?
    val displayName: String

    val companyName: String
    val cnpj: String
    val email: String
    val phone: String
    val municipalRegistration: String?
    val stateRegistration: String?

    val addressPostalCode: String
    val addressState: String
    val addressCity: String
    val addressStreet: String
    val addressNumber: String
    val addressComplement: String?
    val addressNeighborhood: String
    val addressLat: Long?
    val addressLng: Long?

    val cnaeCode: String
    val cnaeDescription: String

    val regime: String
    val specialRegime: String
    val internalPrefectureCode: String?
    val inssRetention: Double

    val plan: String
    //val dueDate: Int

    val paymentData: String?
    val autoPayEnabled: Boolean

    val status: String
    val statusMessage: String
    val createdAt: Timestamp
}
