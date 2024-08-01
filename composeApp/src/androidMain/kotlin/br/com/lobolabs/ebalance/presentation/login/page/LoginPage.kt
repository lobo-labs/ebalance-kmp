package br.com.lobolabs.ebalance.presentation.login.page

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.presentation.ui.component.AppPrimaryButton
import br.com.lobolabs.ebalance.presentation.ui.component.AppSecondaryButton
import br.com.lobolabs.ebalance.presentation.ui.component.AppTextField
import br.com.lobolabs.ebalance.presentation.ui.component.text.AppClickableText
import br.com.lobolabs.ebalance.presentation.ui.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.presentation.ui.component.text.AppTitleText
import br.com.lobolabs.ebalance.presentation.ui.util.AppTheme

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onLoginButtonClick: () -> Unit = {},
    onRegisterButtonClick: () -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(16.dp),
    ) {
        AppTitleText(text = "Olá!")
        Spacer(modifier = Modifier.height(16.dp))
        AppSubtitleText(text = "Bem vindo de volta, faça login na sua conta!")
        Spacer(modifier = Modifier.height(16.dp))
        AppTextField(
            hint = "Email",
            text = "",
            onTextChange = onEmailChange,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        AppTextField(
            hint = "Senha",
            text = "",
            onTextChange = onPasswordChange,
            modifier = Modifier.fillMaxWidth(),
            isPasswordTextField = true
        )
        Spacer(modifier = Modifier.height(32.dp))
        AppClickableText(
            text = "Esqueceu a senha?",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))
        AppPrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Entrar",
            onButtonClick = {
                onLoginButtonClick.invoke()
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        AppSecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Cadastrar",
            onButtonClick = {
                onRegisterButtonClick.invoke()
            }
        )
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun LoginPagePreview() {
    AppTheme {
        LoginPage()
    }
}