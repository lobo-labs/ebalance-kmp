package br.com.lobolabs.ebalance.feature.contract.presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.core.presentation.dskit.feature.contract.ContractListItem
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import feature.contract.domain.model.ContractModel
import feature.contract.domain.ContractFactory

@Composable
fun ContractListPage(
    isLoading: Boolean,
    contracts: List<ContractModel>,
    onItemClick: (ContractModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//                containerColor = MaterialTheme.colorScheme.secondary,
//                onClick = { }
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_add),
//                    contentDescription = ""
//                )
//            }
//        }
    ) {
        LazyColumn(
            modifier = modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = contracts
            ) { contract ->
                ContractListItem(
                    contract = contract,
                    onItemClick = onItemClick
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ContractListPagePreview() {
    AppTheme {
        ContractListPage(
            isLoading = false,
            contracts = ContractFactory.getContracts(),
            onItemClick = {}
        )
    }
}
