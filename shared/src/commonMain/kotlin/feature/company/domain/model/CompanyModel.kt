package feature.company.domain.model

import common.CompanyAddress
import common.CompanyCnae
import common.CompanyData
import common.CompanyPlans
import common.CompanyStatus
import common.CompanyTaxInfo
import kotlinx.serialization.Serializable

@Serializable
data class CompanyModel(
    val id: Long,
    val picture: String?,
    val name: String,
    val data: CompanyData,
    val address: CompanyAddress,
    val cnae: CompanyCnae,
    val taxInfo: CompanyTaxInfo,
    val plan: CompanyPlans,
    val status: CompanyStatus,
    val statusMessage: String
)
