package br.com.lobolabs.ebalance.presentation.ui.component.text

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme

@Composable
fun AppTitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.primary,
        modifier = modifier
    )
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppTitleTextPreview() {
    AppTheme {
        AppTitleText(text = "Título")
    }
}