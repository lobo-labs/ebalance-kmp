package common

import kotlinx.serialization.Serializable

@Serializable
enum class CompanySpecialRegime(
    var value: String
) {
    MICRO_COMPANY("Micro empresa municpal"),
    ESTIMATE("Estimativa"),
    SOCIETY("Sociedade de profissionais"),
    COO("Cooperativa"),
    MEI("MEI - Simples Nacional"),
    ME_EPP("ME EPP - Simples Nacional")
}
