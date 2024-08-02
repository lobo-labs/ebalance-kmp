package br.com.lobolabs.ebalance.core.presentation.dskit.component.image


import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.core.presentation.dskit.component.header.AppHeader
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme

@Composable
fun CardImage(
    @DrawableRes
    imageId: Int,
    modifier: Modifier = Modifier,
    imageColor: Color? = null,
    backgroundColor: Color? = null
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),

        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Image(
            modifier = Modifier.padding(10.dp),
            painter = painterResource(id = imageId),
            colorFilter = ColorFilter.tint(color = imageColor ?: MaterialTheme.colorScheme.secondary),
            contentDescription = ""
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CardImagePreview() {
    AppTheme {
        CardImage(
            imageId = R.drawable.ic_user
        )
    }
}
