package feature.cashin.domain.mapper

import feature.company.domain.mapper.CompanyReferenceMapper
import core.mapper.Mapper
import feature.cashin.data.response.CashInResponse
import feature.cashin.domain.CashInModel

interface CashInMapper: Mapper<CashInResponse, CashInModel>

class CashInMapperImpl(
    private val companyReferenceMapper: CompanyReferenceMapper
): CashInMapper {
    override fun map(from: CashInResponse) = CashInModel(
        id = from.id,
        company = companyReferenceMapper.map(from.company),
        sale = from.sale,
        value = from.value,
        receiptDate = from.receiptDate,
        receiptImage = from.receiptImage
    )
}
