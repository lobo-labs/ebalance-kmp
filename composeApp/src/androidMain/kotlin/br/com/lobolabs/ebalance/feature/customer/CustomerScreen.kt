package br.com.lobolabs.ebalance.feature.customer

import androidx.compose.runtime.Composable

@Composable
fun CustomerScreen() {
    CustomerListPage(
        customers = listOf(),
        onItemClick = {

        }
    )
}
