package domain.customer

object CustomerFactory {
    fun getCustomers() = (0..10).map { getCustomer(it.toLong()) }

    fun getCustomer(id: Long) = Customer(
        id = id,
        name = "LoboLabs",
        cnpj = "55.312.153.0001/15",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389",
        address = null
    )
}