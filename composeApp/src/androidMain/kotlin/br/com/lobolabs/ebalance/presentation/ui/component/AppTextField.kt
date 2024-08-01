package br.com.lobolabs.ebalance.presentation.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.R
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme

@Composable
fun AppTextField(
    hint: String,
    text: String,
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit,
    isPasswordTextField: Boolean = false
) {
    var isFocused by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier.onFocusChanged { isFocused = it.isFocused },
        visualTransformation = if (isPasswordTextField && isPasswordVisible.not()) PasswordVisualTransformation() else VisualTransformation.None,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            textColor = MaterialTheme.colors.onSurface,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        placeholder = {
            Text(text = hint)
        },
        value = text,
        onValueChange = onTextChange,
        trailingIcon = {
            if (isPasswordTextField) {
                val image = R.drawable.ic_eye_closed.takeIf { isPasswordVisible }
                    ?: R.drawable.ic_eye
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isPasswordVisible = isPasswordVisible.not()
                        },
                    tint = MaterialTheme.colors.onSurface
                )
            }
        }
    )

}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppTextFieldPreview() {
    AppTheme {
        AppTextField(
            hint = "E-mail",
            text = "",
            onTextChange = {}
        )
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun AppTextFieldPasswordPreview() {
    AppTheme {
        AppTextField(
            hint = "Senha",
            text = "",
            onTextChange = {},
            isPasswordTextField = true
        )
    }
}