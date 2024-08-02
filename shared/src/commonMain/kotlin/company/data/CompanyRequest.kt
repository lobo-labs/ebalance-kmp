package company.data

import common.CompanyAddress
import common.CompanyCnae
import common.CompanyData
import common.CompanyPlans
import common.CompanyTaxInfo
import kotlinx.serialization.Serializable

@Serializable
class CompanyRequest(
    val name: String,
    val data: CompanyData,
    val address: CompanyAddress,
    val cnae: CompanyCnae,
    val taxInfo: CompanyTaxInfo,
    val plan: CompanyPlans = CompanyPlans.STANDARD,
)
