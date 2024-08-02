package br.com.lobolabs.ebalance.feature.login.presentation

import androidx.lifecycle.viewModelScope
import br.com.lobolabs.ebalance.core.data.ktx.getAppError
import br.com.lobolabs.ebalance.core.presentation.base.BaseViewModel
import br.com.lobolabs.ebalance.feature.login.domain.usecase.SignInUseCase
import br.com.lobolabs.ebalance.feature.login.presentation.stateholder.SignInEffect
import br.com.lobolabs.ebalance.feature.login.presentation.stateholder.SignInEvent
import br.com.lobolabs.ebalance.feature.login.presentation.stateholder.SignInState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : BaseViewModel<SignInState, SignInEffect>(state = SignInState()) {

    fun processEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.OnSignInClick -> onLoginClick()
            is SignInEvent.OnUpdateEmail -> mutableState.update { it.copy(email = event.email) }
            is SignInEvent.OnUpdatePassword -> mutableState.update { it.copy(password = event.password) }
        }
    }

    private fun onLoginClick() {
        viewModelScope.launch {
            signInUseCase(state.value.email, mutableState.value.password)
                .onStart {
                    mutableState.update { it.copy(isLoading = true) }
                }
                .catch { error ->
                    val appError = error.getAppError()
                    onError(appError)
                }
                .collect { result ->
                    mutableState.update { it.copy(isLoading = false) }
                    mutableEffect.emit(SignInEffect.OnSignInSuccess(result))
                }
        }
    }
}