package feature.cashout.domain.mapper

import feature.company.domain.mapper.CompanyReferenceMapper
import core.mapper.Mapper
import feature.cashout.data.response.CashOutResponse
import feature.cashout.domain.model.CashOutModel

interface CashOutMapper: Mapper<CashOutResponse, CashOutModel>

class CashOutMapperImpl(
    private val companyReferenceMapper: CompanyReferenceMapper
): CashOutMapper {
    override fun map(from: CashOutResponse) = CashOutModel(
        id = from.id,
        company = companyReferenceMapper.map(from.company),
        expense = from.expense,
        value = from.value,
        receiptDate = from.receiptDate,
        receiptImage = from.receiptImage
    )
}
