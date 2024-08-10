package feature.company.domain.model

data class CompanyReferenceModel(
    val id: Long,
    val name: String,
    var companyName: String,
    var cnpj: String,
    var email: String,
    var phone: String,
)