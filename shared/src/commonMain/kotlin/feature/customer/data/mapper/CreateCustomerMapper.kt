package feature.customer.data.mapper

import core.mapper.Mapper
import feature.customer.data.model.request.CreateCustomerRequest
import feature.customer.domain.model.CreateCustomer

class CreateCustomerMapper : Mapper<CreateCustomer, CreateCustomerRequest> {
    override fun map(from: CreateCustomer): CreateCustomerRequest {
        return CreateCustomerRequest(
            companyId = from.companyId,
            name = from.name,
            cnpj = from.cnpj,
            email = from.email,
            phone = from.phone,
            address = from.address,
            notes = from.notes,
        )
    }
}