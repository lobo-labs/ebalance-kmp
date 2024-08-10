package br.com.lobolabs.ebalance.feature.customer.presentation.stateholder

sealed interface CustomerListEvent {
    data object ListCustomers: CustomerListEvent
}