package br.com.lobolabs.ebalance.presentation.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme

@Composable
fun AppPrimaryButton(
    text: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        elevation = ButtonDefaults.elevation(0.dp),
        modifier = modifier,
        onClick = {
            onButtonClick.invoke()
        },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        )
    ) {
        Text(
            text = text,
            color = MaterialTheme.colors.onPrimary,
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun EbalancePrimaryButtonPreview() {
    AppTheme {
        AppPrimaryButton(
            text = "Entrar",
            onButtonClick = { }
        )
    }
}
