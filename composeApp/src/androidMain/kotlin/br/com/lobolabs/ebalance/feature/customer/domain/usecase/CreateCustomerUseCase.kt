package br.com.lobolabs.ebalance.feature.customer.domain.usecase

import br.com.lobolabs.ebalance.feature.customer.domain.repository.CustomerRepository
import feature.customer.data.mapper.CreateCustomerMapper
import feature.customer.data.mapper.CustomerMapper
import feature.customer.domain.model.CreateCustomer
import feature.customer.domain.model.Customer

interface CreateCustomerUseCase {
    suspend operator fun invoke(customer: CreateCustomer): Customer
}

class CreateCustomerUseCaseImpl(
    private val repository: CustomerRepository,
    private val mapper: CustomerMapper,
    private val createCustomerMapper: CreateCustomerMapper
) : CreateCustomerUseCase {
    override suspend fun invoke(customer: CreateCustomer): Customer {
        val response = repository.addCustomer(createCustomerMapper.map(customer))
        return mapper.map(response)
    }
}
