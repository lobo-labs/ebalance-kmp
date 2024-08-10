package feature.customer.data.mapper

import core.mapper.Mapper
import feature.customer.data.model.response.CustomerResponse
import feature.customer.domain.model.Customer

class CustomerMapper : Mapper<CustomerResponse, Customer> {
    override fun map(from: CustomerResponse): Customer {
        return Customer(
            id = from.id,
            companyId = from.companyId,
            name = from.name,
            cnpj = from.cnpj,
            email = from.email,
            phone = from.phone,
            address = from.address,
            notes = from.notes,
            isActive = from.isActive
        )
    }
}