package br.com.lobolabs.ebalance.feature.customer.domain.usecase

import br.com.lobolabs.ebalance.feature.customer.domain.repository.CustomerRepository
import feature.customer.data.mapper.CustomerMapper
import feature.customer.domain.model.Customer

interface GetCustomersUseCase {
    suspend operator fun invoke(): List<Customer>
}

class GetCustomersUseCaseImpl(
    private val repository: CustomerRepository,
    private val mapper: CustomerMapper
): GetCustomersUseCase {
    override suspend fun invoke(): List<Customer> =
        repository.getCustomers(1.toString()).map { mapper.map(it) }

}
