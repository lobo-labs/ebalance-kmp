package br.com.lobolabs.ebalance.core.presentation.dskit.component.button

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme

@Composable
fun AppSecondaryButton(
    text: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
        modifier = modifier,
        onClick = {
            onButtonClick.invoke()
        },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppSecondaryButtonPreview() {
    AppTheme {
        AppSecondaryButton(
            text = "Cadastrar",
            onButtonClick = { }
        )
    }
}
