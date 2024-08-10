package br.com.lobolabs.ebalance.feature.customer.domain.usecase

import br.com.lobolabs.ebalance.feature.customer.domain.repository.CustomerRepository
import feature.customer.data.mapper.CustomerMapper
import feature.customer.data.mapper.UpdateCustomerMapper
import feature.customer.domain.model.Customer
import feature.customer.domain.model.UpdateCustomer

interface UpdateCustomerUseCase {
    suspend operator fun invoke(customer: UpdateCustomer): Customer
}

class UpdateCustomerUseCaseImpl(
    private val repository: CustomerRepository,
    private val mapper: CustomerMapper,
    private val updateCustomerMapper: UpdateCustomerMapper
) : UpdateCustomerUseCase {
    override suspend fun invoke(customer: UpdateCustomer): Customer {
        val response = repository.editCustomer(1.toString(), 1.toString(), updateCustomerMapper.map(customer))
        return mapper.map(response)
    }
}
