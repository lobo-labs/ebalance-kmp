package br.com.lobolabs.ebalance.core.presentation.base

import androidx.lifecycle.ViewModel
import core.AppError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<STATE, EFFECT>(state: STATE) : ViewModel() {
    val mutableState = MutableStateFlow(state)
    val state = mutableState.asStateFlow()

    val mutableEffect = MutableSharedFlow<EFFECT>()
    val effect = mutableEffect.asSharedFlow()
    
    open suspend fun onError(error: AppError) {
//        when (error.code) {
//            HttpStatusCode.Unauthorized.value ->
//                mutableEffect.emit(AppErrorEffect.OnUnauthorized)
//            else ->
//                mutableEffect.emit(AppErrorEffect.OnError(error))
//        }
    }
}