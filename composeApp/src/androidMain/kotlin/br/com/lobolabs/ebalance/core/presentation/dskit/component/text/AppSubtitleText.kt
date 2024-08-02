package br.com.lobolabs.ebalance.core.presentation.dskit.component.text

import android.content.res.Configuration
import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme
import br.com.lobolabs.ebalance.core.presentation.util.ktx.buildHtmlText


@Composable
fun AppSubtitleText(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.onBackground,
    isBold: Boolean = false,
    striped: Boolean = false,
) {
    Text(
        text = text.buildHtmlText(),
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