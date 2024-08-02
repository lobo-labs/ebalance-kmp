package br.com.lobolabs.ebalance.core.presentation.dskit.component.loading

import android.content.res.Configuration
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme

@Composable
fun AppProgressBar() {
    CircularProgressIndicator(
        progress = 0.5f,
        color = MaterialTheme.colors.secondary,
        backgroundColor = MaterialTheme.colors.onSecondary,
        strokeCap = StrokeCap.Round,
        strokeWidth = 5.dp
    )
}
@Composable

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppProgressBarPreview() {
    AppTheme {
        AppProgressBar()
    }
}