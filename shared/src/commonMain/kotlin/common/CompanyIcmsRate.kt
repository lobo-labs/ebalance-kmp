package common

import kotlinx.serialization.Serializable

@Serializable
class CompanyIcmsRate(
    val validity: String, // Vigencia - 08/2022
    val rate: Double = 0.0,
)