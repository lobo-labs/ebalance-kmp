package br.com.lobolabs.ebalance.feature.contract.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.lobolabs.ebalance.feature.contract.presentation.stateholder.ContractEffect
import br.com.lobolabs.ebalance.feature.contract.presentation.stateholder.ContractEvent

@Composable
fun ContractScreen(
    viewModel: ContractViewModel = viewModel(ContractViewModel::class.java)
) {
    val state = viewModel.state.collectAsState().value
    val effect = viewModel.effect.collectAsState(null).value

    viewModel.processEvent(ContractEvent.ListContracts)

    ContractListPage(
        isLoading = state.isLoading,
        contracts = state.contracts,
        onItemClick = {}
    )
}
