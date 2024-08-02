package company

import company.domain.CompanyReference
import customer.domain.Customer

object CompanyFactory {
    fun getCompanies() = (0..10).map { getCompany(it.toLong()) }

    fun getCompany(id: Long) = CompanyReference(
        id = 1,
        companyName = "LoboLabs",
        name = "LoboLabs",
        cnpj = "32.901.153/00001-04",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389"
    )

    fun getReference(id: Long) = CompanyReference(
        id = 1,
        companyName = "LoboLabs",
        name = "LoboLabs",
        cnpj = "32.901.153/00001-04",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389"
    )
}