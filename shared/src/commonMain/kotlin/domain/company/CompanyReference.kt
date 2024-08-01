package domain.company

data class CompanyReference(
    val id: Long,
    val name: String,
    var companyName: String,
    var cnpj: String,
    var email: String,
    var phone: String,
)