package common

import kotlinx.serialization.Serializable

@Serializable
class CompanyAddress(
    val postalCode: String,
    val state: String,
    val city: String,
    val street: String,
    val number: String,
    val complement: String?,
    val neighborhood: String,
    val lat: Long?,
    val lng: Long?,
)