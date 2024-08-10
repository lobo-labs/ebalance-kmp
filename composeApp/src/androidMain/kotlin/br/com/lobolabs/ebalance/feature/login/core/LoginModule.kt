package br.com.lobolabs.ebalance.feature.login.core

import br.com.lobolabs.ebalance.core.di.DISPATCHER_IO
import br.com.lobolabs.ebalance.feature.login.data.api.SignInApi
import br.com.lobolabs.ebalance.feature.login.data.api.SignInApiImpl
import br.com.lobolabs.ebalance.feature.login.data.repository.SignInRepositoryImpl
import br.com.lobolabs.ebalance.feature.login.domain.SignInRepository
import br.com.lobolabs.ebalance.feature.login.domain.usecase.SignInUseCase
import br.com.lobolabs.ebalance.feature.login.domain.usecase.SignInUseCaseImpl
import feature.auth.domain.mapper.SignInMapper
import feature.auth.domain.mapper.SignInMapperImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val signInModule = module {
    single<SignInApi> { SignInApiImpl(get()) }
    single<SignInRepository> { SignInRepositoryImpl(get(), get(named(DISPATCHER_IO))) }
    single<SignInMapper> { SignInMapperImpl(get()) }
    single<SignInUseCase> { SignInUseCaseImpl(get(), get(), get(named(DISPATCHER_IO))) }
}
