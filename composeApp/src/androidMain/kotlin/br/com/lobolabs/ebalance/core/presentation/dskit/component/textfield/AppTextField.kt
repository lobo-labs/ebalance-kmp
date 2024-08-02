package br.com.lobolabs.ebalance.core.presentation.dskit.component.textfield

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme

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
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedBorderColor = MaterialTheme.colorScheme.surface,
            unfocusedBorderColor = MaterialTheme.colorScheme.surface,
            // focusedTextColor = MaterialTheme.colorScheme.surface
//            containerColor = MaterialTheme.colorScheme.surface,
//            textColor = MaterialTheme.colorScheme.onSurface,
//            focusedBorderColor = Color.Transparent,
//            unfocusedBorderColor = Color.Transparent
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
                    tint = MaterialTheme.colorScheme.onSurface
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