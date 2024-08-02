package br.com.lobolabs.ebalance.core.presentation.base.stateholder

import core.AppError

sealed interface AppErrorEffect {
    data class OnError(val error: AppError) : AppErrorEffect
    data object OnUnauthorized : AppErrorEffect
}