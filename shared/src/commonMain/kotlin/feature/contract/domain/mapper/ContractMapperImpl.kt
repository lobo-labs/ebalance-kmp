package feature.contract.domain.mapper

import core.mapper.Mapper
import feature.contract.data.response.ContractResponse
import feature.contract.domain.model.ContractModel

interface ContractMapper : Mapper<ContractResponse, ContractModel>

class ContractMapperImpl : ContractMapper {
    override fun map(from: ContractResponse) = ContractModel(
        id = from.id,
        companyId = from.companyId,
        startDate = from.startDate,
        endDate = from.endDate,
        plan = from.plan,
        planPrice = from.planPrice,
        usedDays = from.usedDays,
        totalDays = from.totalDays,
        fees = from.fees,
        penalty = from.penalty,
        subtotal = from.subtotal,
        discount = from.discount,
        total = from.total,
        paymentDate = from.paymentDate,
        paymentMethod = from.paymentMethod,
        isPaid = from.isPaid,
        isActive = from.isActive,
        needUpdateTaxes = from.needUpdateTaxes
    )
}
