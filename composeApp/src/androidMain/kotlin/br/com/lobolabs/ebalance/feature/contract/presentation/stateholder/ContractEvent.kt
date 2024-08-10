package br.com.lobolabs.ebalance.feature.contract.presentation.stateholder

sealed interface ContractEvent {
    data object ListContracts: ContractEvent
}