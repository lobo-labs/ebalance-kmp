package br.com.lobolabs.ebalance.feature.customer.domain.repository

import feature.customer.data.model.request.CreateCustomerRequest
import feature.customer.data.model.request.UpdateCustomerRequest
import feature.customer.data.model.response.CustomerResponse

interface CustomerRepository {
    suspend fun addCustomer(
        request: CreateCustomerRequest
    ): CustomerResponse
    suspend fun editCustomer(
        companyId: String,
        customerId: String,
        request: UpdateCustomerRequest
    ): CustomerResponse

    suspend fun getCustomers(companyId: String): List<CustomerResponse>
}