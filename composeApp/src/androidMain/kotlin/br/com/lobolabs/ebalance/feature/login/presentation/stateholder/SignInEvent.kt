package br.com.lobolabs.ebalance.feature.login.presentation.stateholder

sealed interface SignInEvent {
    data class OnUpdateEmail(val email: String) : SignInEvent
    data class OnUpdatePassword(val password: String) : SignInEvent
    data object OnSignInClick : SignInEvent
}