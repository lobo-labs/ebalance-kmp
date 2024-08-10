package br.com.lobolabs.ebalance.feature.receiver

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.core.presentation.dskit.feature.receiver.ReceiverListItem
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import feature.receiver.ReceiverFactory
import feature.receiver.domain.Receiver

@Composable
fun ReceiverListPage(
    receivers: List<Receiver>,
    onItemClick: (Receiver) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = receivers
        ) { receiver ->
            ReceiverListItem(
                receiver = receiver,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ProviderListPagePreview() {
    AppTheme {
        ReceiverListPage(
            receivers = ReceiverFactory.getReceivers(),
            onItemClick = {}
        )
    }
}
