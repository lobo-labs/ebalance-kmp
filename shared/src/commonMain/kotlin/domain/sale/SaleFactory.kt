package domain.sale

import domain.company.CompanyReference
import domain.customer.CustomerReference
import domain.receiver.ReceiverReference

object SaleFactory {
    fun getSales() = (0..10).map { getSale(it.toLong()) }

    fun getSale(id: Long) = Sale(
        id = id,
        company = CompanyReference(
            id = 1,
            companyName = "LoboLabs",
            name = "LoboLabs",
            cnpj = "32.901.153/00001-04",
            email = "admin@lobolabs.com.br",
            phone = "(84) 99820-2499"
        ),
        notes = null,
        customer = CustomerReference(
            id = 1,
            name = "Lobo Neto",
            cnpj = "32.901.153/00001-04",
            email = "lobonetoc@gmail.com",
            phone = "(84) 99820-2499"
        ),
        receiver = ReceiverReference(
            id = 1,
            name = "Lobo Neto",
            cnpj = "32.901.153/00001-04",
            email = "lobonetoc@gmail.com",
            phone = "(84) 99820-2499"
        ),
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
