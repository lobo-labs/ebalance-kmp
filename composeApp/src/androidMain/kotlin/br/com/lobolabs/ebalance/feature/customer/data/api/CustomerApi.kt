package br.com.lobolabs.ebalance.feature.customer.data.api

import feature.customer.data.model.request.CreateCustomerRequest
import feature.customer.data.model.request.UpdateCustomerRequest
import feature.customer.data.model.response.CustomerResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody

interface CustomerApi {
    suspend fun addCustomer(
        request: CreateCustomerRequest
    ): CustomerResponse
    suspend fun editCustomer(
        companyId: String,
        customerId: String,
        request: UpdateCustomerRequest
    ): CustomerResponse

    suspend fun getCustomers(): List<CustomerResponse>
}

class CustomerApiImpl(
    private val client: HttpClient
) : CustomerApi {
    override suspend fun addCustomer(request: CreateCustomerRequest): CustomerResponse {
        return client.post("https://ebalance-api.lobolabs.com.br/api/customers") {
            setBody(request)
        }.body()
    }

    override suspend fun editCustomer(
        companyId: String,
        customerId: String,
        request: UpdateCustomerRequest
    ): CustomerResponse {
        return client.put("https://ebalance-api.lobolabs.com.br/api/companies/$companyId/customers/$customerId") {
            setBody(request)
        }.body()
    }

    override suspend fun getCustomers(): List<CustomerResponse> {
        return client.get("https://ebalance-api.lobolabs.com.br/api/customers").body()
    }
}