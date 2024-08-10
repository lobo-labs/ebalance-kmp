package br.com.lobolabs.ebalance.feature.auth.di

import br.com.lobolabs.ebalance.feature.auth.domain.usecase.ValidateJwtUseCase
import br.com.lobolabs.ebalance.feature.auth.domain.usecase.ValidateJwtUseCaseImpl
import br.com.lobolabs.ebalance.feature.auth.domain.usecase.ValidatePasswordUseCase
import br.com.lobolabs.ebalance.feature.auth.domain.usecase.ValidatePasswordUseCaseImpl
import org.koin.dsl.module

val authModule = module {
    single<ValidateJwtUseCase> { ValidateJwtUseCaseImpl() }
    single<ValidatePasswordUseCase> { ValidatePasswordUseCaseImpl(get()) }
}
