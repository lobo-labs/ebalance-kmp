package br.com.lobolabs.ebalance.feature.company

import org.ktorm.schema.*

object CompanyTable : Table<CompanyDao>("companies") {
    val id = long("id").primaryKey().bindTo { it.id }

    val picture = bytes("picture").bindTo { it.picture }
    val displayName = varchar("display_name").bindTo { it.displayName }

    val companyName = varchar("company_name").bindTo { it.companyName }
    val cnpj = varchar("cnpj").bindTo { it.cnpj }
    val email = varchar("email").bindTo { it.email }
    val phone = varchar("phone").bindTo { it.phone }
    val municipalRegistration = varchar("municipal_registration").bindTo { it.municipalRegistration }
    val stateRegistration = varchar("state_registration").bindTo { it.stateRegistration }

    val addressPostalCode = varchar("address_postal_code").bindTo { it.addressPostalCode }
    val addressState = varchar("address_state").bindTo { it.addressState }
    val addressCity = varchar("address_city").bindTo { it.addressCity }
    val addressStreet = varchar("address_street").bindTo { it.addressStreet }
    val addressNumber = varchar("address_number").bindTo { it.addressNumber }
    val addressComplement = varchar("address_complement").bindTo { it.addressComplement }
    val addressNeighborhood = varchar("address_neighborhood").bindTo { it.addressNeighborhood }
    val addressLat = long("address_lat").bindTo { it.addressLat }
    val addressLng = long("address_lng").bindTo { it.addressLng }

    val cnaeCode = varchar("cnae_code").bindTo { it.cnaeCode }
    val cnaeDescription = varchar("cnae_description").bindTo { it.cnaeDescription }

    val regime = varchar("regime").bindTo { it.regime }
    val specialRegime = varchar("special_regime").bindTo { it.specialRegime }
    val internalPrefectureCode = varchar("internal_prefecture_code").bindTo { it.internalPrefectureCode }
    val inssRetention = double("inss_retention").bindTo { it.inssRetention }

    val plan = varchar("plan").bindTo { it.plan }
    //val dueDate = int("due_date").bindTo { it.dueDate }

    val paymentData = varchar("payment_data").bindTo { it.paymentData }
    val autoPayEnabled = boolean("auto_pay_enabled").bindTo { it.autoPayEnabled }

    val status = varchar("status").bindTo { it.status }
    val statusMessage = varchar("status_message").bindTo { it.statusMessage }
    val createdAt = jdbcTimestamp("created_at").bindTo { it.createdAt }
}
