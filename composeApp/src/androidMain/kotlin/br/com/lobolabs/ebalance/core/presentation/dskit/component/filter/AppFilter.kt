package br.com.lobolabs.ebalance.core.presentation.dskit.component.filter

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme


@Composable
fun AppFilter(
    text: String,
    modifier: Modifier = Modifier,
    onItemChanged: () -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        shape = CircleShape,
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surface),
        onClick = onItemChanged

    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AppSubtitleText(
                text = text,
                textColor = MaterialTheme.colorScheme.primary
            )
            Image(
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.secondary),
                painter = painterResource(id = R.drawable.ic_expand),
                contentDescription = ""
            )
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppFilterPreview() {
    AppTheme {
        AppFilter(
            text = "Filtro",
            onItemChanged = {

            }
        )
    }
}
