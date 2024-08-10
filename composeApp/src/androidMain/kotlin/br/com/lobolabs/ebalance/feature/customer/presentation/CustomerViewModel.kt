package br.com.lobolabs.ebalance.feature.customer.presentation

import android.view.View
import br.com.lobolabs.ebalance.core.presentation.base.BaseViewModel
import br.com.lobolabs.ebalance.feature.customer.presentation.stateholder.CustomerListState

class CustomerViewModel : BaseViewModel<CustomerListState, Unit>(CustomerListState()) {
}