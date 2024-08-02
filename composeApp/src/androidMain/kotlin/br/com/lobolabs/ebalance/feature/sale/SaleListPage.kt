package br.com.lobolabs.ebalance.feature.sale

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
import br.com.lobolabs.ebalance.core.presentation.dskit.feature.sale.SaleListItem
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import sale.SaleFactory
import sale.domain.Sale

@Composable
fun SaleListPage(
    sales: List<Sale>,
    onItemClick: (Sale) -> Unit,
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
            items = sales
        ) { sale ->
            SaleListItem(
                onItemClick = onItemClick,
                sale = sale
            )
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SaleListPagePreview() {
    AppTheme {
        SaleListPage(
            sales = SaleFactory.getSales(),
            onItemClick = {}
        )
    }
}
