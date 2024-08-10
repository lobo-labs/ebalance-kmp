package br.com.lobolabs.ebalance.feature.company.domain.util

import br.com.lobolabs.ebalance.core.data.ktx.formattedCpfOrCnpj
import br.com.lobolabs.ebalance.core.data.ktx.formattedPhone
import br.com.lobolabs.ebalance.feature.company.CompanyDao
import common.CompanyAddress
import common.CompanyCnae
import common.CompanyData
import common.CompanyIcmsRate
import common.CompanyPlans
import common.CompanyRegime
import common.CompanySpecialRegime
import common.CompanyStatus
import common.CompanyTaxInfo
import feature.company.data.CompanyReferenceResponse
import feature.company.data.CompanyResponse
import java.util.Base64

fun List<CompanyDao>.mapToCompanyListResponse(): List<CompanyResponse> {
    return this.map { it.mapToCompanyResponse() }
}

fun CompanyDao.mapToCompanyResponse(
    icmsRates: List<CompanyIcmsRate> = emptyList()
): CompanyResponse {
    return CompanyResponse(
        id = id,
        picture = picture?.let { Base64.getEncoder().encodeToString(it) },
        name = displayName,
        data = CompanyData(
            companyName,
            cnpj.formattedCpfOrCnpj(),
            email,
            phone.formattedPhone(),
            municipalRegistration,
            stateRegistration
        ),
        address = CompanyAddress(
            addressPostalCode,
            addressState,
            addressCity,
            addressStreet,
            addressNumber,
            addressComplement,
            addressNeighborhood,
            addressLat,
            addressLng
        ),
        cnae = CompanyCnae(
            cnaeCode,
            cnaeDescription
        ),
        taxInfo = CompanyTaxInfo(
            CompanyRegime.valueOf(regime),
            CompanySpecialRegime.valueOf(specialRegime),
            internalPrefectureCode,
            inssRetention,
            icmsRates
        ),
        plan = CompanyPlans.valueOf(plan),
        status = CompanyStatus.valueOf(status),
        statusMessage = statusMessage
    )
}

fun CompanyDao.mapToReferenceResponse(): CompanyReferenceResponse {
    return CompanyReferenceResponse(
        this.id,
        this.displayName,
        this.companyName,
        this.cnpj,
        this.email,
        this.phone.formattedPhone()
    )
}
