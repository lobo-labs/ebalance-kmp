package br.com.lobolabs.ebalance.feature.login.presentation.stateholder

import feature.auth.domain.model.SignInModel

sealed interface SignInEffect {
    data class OnSignInSuccess(val result: SignInModel) : SignInEffect
}
