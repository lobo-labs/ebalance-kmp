package br.com.lobolabs.ebalance.feature.contract.presentation.stateholder

import feature.contract.domain.model.ContractModel

data class ContractListState(
    val isLoading: Boolean = false,
    val contracts: List<ContractModel> = listOf()
)
