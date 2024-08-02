package br.com.lobolabs.ebalance.feature.login.presentation.stateholder

data class SignInState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = ""
)

