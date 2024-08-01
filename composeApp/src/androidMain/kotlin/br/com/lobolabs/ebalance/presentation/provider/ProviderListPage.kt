package br.com.lobolabs.ebalance.presentation.provider

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.presentation.ui.component.provider.ProviderListItem
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme
import domain.provider.Provider
import domain.provider.ProviderFactory
import domain.sale.SaleFactory

@Composable
fun ProviderListPage(
    providers: List<Provider>,
    onItemClick: (Provider) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = providers
        ) { provider ->
            ProviderListItem(
                onItemClick = onItemClick,
                provider = provider
            )
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ProviderListPagePreview() {
    AppTheme {
        ProviderListPage(
            providers = ProviderFactory.getProviders(),
            onItemClick = {}
        )
    }
}
