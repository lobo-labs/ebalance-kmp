package br.com.lobolabs.ebalance.core.di

import br.com.lobolabs.ebalance.feature.login.data.repository.SignInRepositoryImpl
import br.com.lobolabs.ebalance.feature.login.domain.SignInRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<SignInRepository> {
        SignInRepositoryImpl(get(), get())
    }
}
