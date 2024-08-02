package br.com.lobolabs.ebalance.feature.login.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.lobolabs.ebalance.feature.login.page.SignInPage
import br.com.lobolabs.ebalance.feature.login.presentation.stateholder.SignInEffect
import br.com.lobolabs.ebalance.feature.login.presentation.stateholder.SignInEvent

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = koinV(SignInViewModel::class.java)
) {
    val state = viewModel.state.collectAsState().value
    val effect = viewModel.effect.collectAsState(null).value
    when (effect) {
        is SignInEffect.OnSignInSuccess -> {

        }
        null -> {

        }
    }
    SignInPage(
        isLoading = state.isLoading,
        email = state.email,
        password = state.password,
        onSignInClick = {
            viewModel.processEvent(SignInEvent.OnSignInClick)
        },
        onSignUpClick = {

        },
        onEmailChange = { email ->
            viewModel.processEvent(SignInEvent.OnUpdateEmail(email))
        },
        onPasswordChange = { password ->
            viewModel.processEvent(SignInEvent.OnUpdateEmail(password))
        }
    )
}
