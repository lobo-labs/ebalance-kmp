package feature.company

import feature.company.domain.model.CompanyReferenceModel

object CompanyFactory {
    fun getCompanies() = (0..10).map { getCompany(it.toLong()) }

    fun getCompany(id: Long) = CompanyReferenceModel(
        id = 1,
        companyName = "LoboLabs",
        name = "LoboLabs",
        cnpj = "32.901.153/00001-04",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389"
    )

    fun getReference(id: Long) = CompanyReferenceModel(
        id = 1,
        companyName = "LoboLabs",
        name = "LoboLabs",
        cnpj = "32.901.153/00001-04",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389"
    )
}