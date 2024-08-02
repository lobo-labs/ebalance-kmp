package br.com.lobolabs.ebalance.feature.login.presentation.stateholder

import feature.auth.domain.SignInResult

sealed interface SignInEffect {
    data class OnSignInSuccess(val result: SignInResult) : SignInEffect
}
