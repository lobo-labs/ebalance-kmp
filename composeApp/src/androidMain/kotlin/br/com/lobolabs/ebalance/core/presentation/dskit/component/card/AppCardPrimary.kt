package br.com.lobolabs.ebalance.core.presentation.dskit.component.card

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppCardPrimary(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colors.primary
        ),
        elevation = 0.dp,
        shape = RoundedCornerShape(14.dp),
        onClick = { onClick() }
    ) {
        content()
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppCardPrimaryPreview() {
    AppTheme {
        AppCardPrimary(
            onClick = { }
        ) {
            Box(modifier = Modifier.size(50.dp))
        }
    }
}