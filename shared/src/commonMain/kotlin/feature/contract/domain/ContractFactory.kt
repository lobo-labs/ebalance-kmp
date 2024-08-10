package feature.contract.domain

import common.CompanyPlans
import feature.contract.domain.model.ContractModel

object ContractFactory {
    fun getContracts() = (0..10).map { getContract(it.toLong()) }

    fun getContract(id: Long) = ContractModel(
        id = id,
        companyId = 1,
        startDate = "08/02/2024",
        endDate = "08/02/2024",
        plan = CompanyPlans.STANDARD.name,
        planPrice = CompanyPlans.STANDARD.monthlyPayment,
        usedDays = 30,
        totalDays = 30,
        fees = 0.0,
        penalty = 0.0,
        subtotal = 100.0,
        discount = 0.0,
        total = 100.0,
        paymentDate = null,
        paymentMethod = null,
        isPaid = true,
        isActive = true,
        needUpdateTaxes = false
    )
}
