package br.com.lobolabs.ebalance.feature.customer.data.repository

import br.com.lobolabs.ebalance.feature.customer.data.api.CustomerApi
import br.com.lobolabs.ebalance.feature.customer.domain.repository.CustomerRepository
import feature.customer.data.model.request.CreateCustomerRequest
import feature.customer.data.model.request.UpdateCustomerRequest
import feature.customer.data.model.response.CustomerResponse

class CustomerRepositoryImpl(
    private val api: CustomerApi
) : CustomerRepository {
    override suspend fun addCustomer(request: CreateCustomerRequest): CustomerResponse {
        return api.addCustomer(request)
    }

    override suspend fun editCustomer(
        companyId: String,
        customerId: String,
        request: UpdateCustomerRequest
    ): CustomerResponse {
        return api.editCustomer(companyId, customerId, request)
    }

    override suspend fun getCustomers(companyId: String): List<CustomerResponse> {
        return api.getCustomers()
    }
}