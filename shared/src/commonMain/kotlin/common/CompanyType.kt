package common

import kotlinx.serialization.Serializable

@Serializable
enum class CompanyType(
    var value: String
) {
    DENTAL_PROSTHETIC("Protetico dental"),
    SOFTWARE_HOUSE("Empresa de Software")
}
