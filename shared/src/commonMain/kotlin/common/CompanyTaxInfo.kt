package common

import kotlinx.serialization.Serializable

@Serializable
class CompanyTaxInfo(
    val regime: CompanyRegime,
    val specialRegime: CompanySpecialRegime,
    val internalPrefectureCode: String?,
    val inssRetention: Double,
    val icmsRates: List<CompanyIcmsRate>,
)