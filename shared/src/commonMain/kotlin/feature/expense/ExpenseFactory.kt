package feature.expense

import feature.company.CompanyFactory
import feature.expense.domain.ExpenseModel
import feature.provider.ProviderFactory

object ExpenseFactory {

    fun getExpenses() = (0..10).map { getExpense(it.toLong()) }

    fun getExpense(id: Long) = ExpenseModel(
        id = id,
        company = CompanyFactory.getReference(id),
        description = "Despesa com serviço",
        provider = ProviderFactory.getReference(id),
        value = 100.0,
        cashOut = 0.0,
        toPay = 50.0,
        entryDate = "01/12/2023",
        finishDate = "31/12/2023",
        isPaid = false,
        paymentDate = "",
        isCancelled = false
    )
}
