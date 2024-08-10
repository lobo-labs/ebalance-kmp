package br.com.lobolabs.ebalance.feature.contract.presentation

import androidx.lifecycle.viewModelScope
import br.com.lobolabs.ebalance.core.data.ktx.getAppError
import br.com.lobolabs.ebalance.core.presentation.base.BaseViewModel
import br.com.lobolabs.ebalance.feature.contract.domain.GetContractsUseCase
import br.com.lobolabs.ebalance.feature.contract.presentation.stateholder.ContractEffect
import br.com.lobolabs.ebalance.feature.contract.presentation.stateholder.ContractEvent
import br.com.lobolabs.ebalance.feature.contract.presentation.stateholder.ContractListState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContractViewModel(
    private val useCase: GetContractsUseCase
) : BaseViewModel<ContractListState, ContractEffect>(ContractListState()) {

    fun processEvent(event: ContractEvent) {
        when (event) {
            ContractEvent.ListContracts -> getContracts()
        }
    }

    private fun getContracts() {
        viewModelScope.launch {
            useCase()
                .onStart {
                    mutableState.update { it.copy(isLoading = true) }
                }
                .catch {
                    onError(it.getAppError())
                }
                .collect { contracts ->
                    mutableState.update { it.copy(isLoading = false, contracts = contracts) }
                }
        }
    }
}