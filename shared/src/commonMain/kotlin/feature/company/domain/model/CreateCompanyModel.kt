package feature.company.domain.model

import common.CompanyAddress
import common.CompanyCnae
import common.CompanyData
import common.CompanyPlans
import common.CompanyTaxInfo

class CreateCompanyModel(
    val name: String,
    val data: CompanyData,
    val address: CompanyAddress,
    val cnae: CompanyCnae,
    val taxInfo: CompanyTaxInfo,
    val plan: CompanyPlans
)
