package br.com.lobolabs.ebalance.presentation.ui.component.text

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme

@Composable
fun AppSubtitleText(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.onBackground,
    isBold: Boolean = false,
    striped: Boolean = false,
) {
    Text(
        text = text,
        fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
        fontSize = 16.sp,
        color = textColor,
        modifier = modifier,
        style = TextStyle(textDecoration = TextDecoration.LineThrough).takeIf { striped }
            ?: TextStyle()
    )
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppSubtitleTextPreview() {
    AppTheme {
        AppSubtitleText(text = "Subtítulo")
    }
}