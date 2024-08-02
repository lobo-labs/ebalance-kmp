package common

import kotlinx.serialization.Serializable

@Serializable
class CompanyData(
    var companyName: String,
    var cnpj: String,
    var email: String,
    var phone: String,
    var municipalRegistration: String?,
    var stateRegistration: String?,
)