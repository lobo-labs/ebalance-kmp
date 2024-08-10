package feature.company.domain.mapper

import core.mapper.Mapper
import feature.company.data.CreateCompanyRequest
import feature.company.domain.model.CreateCompanyModel

interface CreateCompanyMapper: Mapper<CreateCompanyRequest, CreateCompanyModel>

class CreateCompanyMapperImpl : CreateCompanyMapper {
    override fun map(from: CreateCompanyRequest) = CreateCompanyModel(
        name = from.name,
        data = from.data,
        address = from.address,
        cnae = from.cnae,
        taxInfo = from.taxInfo,
        plan = from.plan,
    )
}
