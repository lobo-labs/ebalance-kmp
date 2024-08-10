package feature.company.domain.mapper

import feature.company.data.CompanyResponse
import feature.company.domain.model.CompanyModel
import core.mapper.Mapper

interface CompanyMapper: Mapper<CompanyResponse, CompanyModel>

class CashInMapperImpl : CompanyMapper {
    override fun map(from: CompanyResponse) = CompanyModel(
        id = from.id,
        picture = from.picture,
        name = from.name,
        data = from.data,
        address = from.address,
        cnae = from.cnae,
        taxInfo = from.taxInfo,
        plan = from.plan,
        status = from.status,
        statusMessage = from.statusMessage
    )
}
