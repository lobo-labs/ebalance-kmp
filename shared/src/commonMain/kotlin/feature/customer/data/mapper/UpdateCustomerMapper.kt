package feature.customer.data.mapper

import core.mapper.Mapper
import feature.customer.data.model.request.UpdateCustomerRequest
import feature.customer.domain.model.UpdateCustomer

class UpdateCustomerMapper : Mapper<UpdateCustomer, UpdateCustomerRequest> {
    override fun map(from: UpdateCustomer): UpdateCustomerRequest {
        return UpdateCustomerRequest(
            name = from.name,
            cnpj = from.cnpj,
            email = from.email,
            phone = from.phone,
            notes = from.notes
        )
    }
}
