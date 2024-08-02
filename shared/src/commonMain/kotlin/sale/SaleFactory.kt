package sale

import company.CompanyFactory
import customer.CustomerFactory
import receiver.ReceiverFactory
import sale.domain.Sale

object SaleFactory {
    fun getSales() = (0..10).map { getSale(it.toLong()) }

    fun getSale(id: Long) = Sale(
        id = id,
        company = CompanyFactory.getReference(id),
        notes = null,
        customer = CustomerFactory.getReference(id),
        receiver = ReceiverFactory.getReference(id),
        items = listOf(),
        cashIns = listOf(),
        subtotal = 100.0,
        discount = 0.0,
        total = 100.0,
        cashIn = 0.0,
        toReceive = 50.0,
        entryDate = "01/12/2023",
        finishDate = "31/12/2023",
        isLate = false,
        lateDays = 0,
        isPaid = false,
        receiptImage = null,
        paymentDate = "",
        isCancelled = false
    )
}
