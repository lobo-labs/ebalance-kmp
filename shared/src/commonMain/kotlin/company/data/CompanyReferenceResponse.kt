package company.data

import kotlinx.serialization.Serializable

@Serializable
data class CompanyReferenceResponse(
    val id: Long,
    val name: String,
    var companyName: String,
    var cnpj: String,
    var email: String,
    var phone: String,
)