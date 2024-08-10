package feature.company.domain.mapper

import feature.company.data.CompanyReferenceResponse
import feature.company.domain.model.CompanyReferenceModel
import core.mapper.Mapper

interface CompanyReferenceMapper : Mapper<CompanyReferenceResponse, CompanyReferenceModel>

class CompanyReferenceMapperImpl : CompanyReferenceMapper {
    override fun map(from: CompanyReferenceResponse) = CompanyReferenceModel(
        id = from.id,
        name = from.name,
        companyName = from.companyName,
        cnpj = from.cnpj,
        email = from.email,
        phone = from.phone
    )
}
