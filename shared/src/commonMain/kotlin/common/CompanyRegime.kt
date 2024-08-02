package common

import kotlinx.serialization.Serializable

@Serializable
enum class CompanyRegime(
    var value: String
) {
    MEI("MEI"),
    SIMPLE("Simples Nacional"),
    PRESUMED_PROFIT("Lucro presumido")
}
