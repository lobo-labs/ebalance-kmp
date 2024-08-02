package br.com.lobolabs.ebalance.feature.login.page

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lobolabs.ebalance.core.presentation.dskit.component.button.AppPrimaryButton
import br.com.lobolabs.ebalance.core.presentation.dskit.component.button.AppSecondaryButton
import br.com.lobolabs.ebalance.core.presentation.dskit.component.loading.AppProgressBar
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppClickableText
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppSubtitleText
import br.com.lobolabs.ebalance.core.presentation.dskit.component.text.AppTitleText
import br.com.lobolabs.ebalance.core.presentation.dskit.component.textfield.AppTextField
import br.com.lobolabs.ebalance.core.presentation.util.AppTheme

@Composable
fun SignInPage(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    email: String,
    onEmailChange: (String) -> Unit = {},
    password: String,
    onPasswordChange: (String) -> Unit = {},
    onSignInClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {

    Box {
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(16.dp),
        ) {
            AppTitleText(text = "Olá!")
            Spacer(modifier = Modifier.height(16.dp))
            AppSubtitleText(text = "Bem vindo de volta, faça login na sua conta!")
            Spacer(modifier = Modifier.height(16.dp))
            AppTextField(
                hint = "Email",
                text = email,
                onTextChange = onEmailChange,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            AppTextField(
                hint = "Senha",
                text = password,
                onTextChange = onPasswordChange,
                modifier = Modifier.fillMaxWidth(),
                isPasswordTextField = true
            )
            Spacer(modifier = Modifier.height(32.dp))
            AppClickableText(
                text = "Esqueceu a senha?",
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            AppPrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Entrar",
                onButtonClick = onSignInClick
            )
            Spacer(modifier = Modifier.height(8.dp))
            AppSecondaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Cadastrar",
                onButtonClick = onSignUpClick
            )
        }

        Box(modifier = Modifier.matchParentSize(), contentAlignment = Alignment.Center) {
            AnimatedVisibility(visible = isLoading) {
                AppProgressBar()
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun LoginPagePreview() {
    AppTheme {
        SignInPage(
            isLoading = false,
            email = "",
            onEmailChange = {},
            password = "",
            onPasswordChange = {},
            onSignInClick = {},
            onSignUpClick = {},
        )
    }
}