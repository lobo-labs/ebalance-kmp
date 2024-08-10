package br.com.lobolabs.ebalance.feature.customer.presentation.stateholder

import feature.customer.domain.model.Customer

data class CustomerListState(
    val isLoading: Boolean = false,
    val customers: List<Customer> = listOf()
)
