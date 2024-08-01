package br.com.lobolabs.ebalance.presentation.ui.component.provider

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.presentation.ui.component.image.CardImage
import br.com.lobolabs.ebalance.presentation.ui.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme
import domain.provider.Provider
import domain.provider.ProviderFactory

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProviderListItem(
    modifier: Modifier = Modifier,
    onItemClick: (Provider) -> Unit,
    isSelected: Boolean = false,
    provider: Provider
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background,
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colors.secondary.takeIf {
                isSelected
            } ?: MaterialTheme.colors.surface
        ),
        elevation = 0.dp,
        shape = RoundedCornerShape(14.dp),
        onClick = { onItemClick(provider) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            CardImage(
                imageId = R.drawable.ic_box,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
            ) {
                AppSubtitleText(
                    text = provider.name,
                    isBold = true,
                    textColor = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(end = 8.dp, top = 8.dp)
                )
                AppSubtitleText(
                    text = provider.phone ?: "Telefone não informado",
                    modifier = Modifier.padding(end = 8.dp, top = 4.dp)
                )
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun ProviderListItemPreview() {
    AppTheme {
        ProviderListItem(
            provider = ProviderFactory.getProvider(1),
            onItemClick = {}
        )
    }
}
