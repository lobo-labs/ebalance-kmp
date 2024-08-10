package br.com.lobolabs.ebalance.feature.user.core

import br.com.lobolabs.ebalance.backend.entity.user.domain.use_case.AddUserUseCase
import br.com.lobolabs.ebalance.backend.entity.user.domain.use_case.AddUserUseCaseImpl
import br.com.lobolabs.ebalance.feature.user.data.repository.UserRepositoryImpl
import br.com.lobolabs.ebalance.feature.user.domain.repository.UserRepository
import br.com.lobolabs.ebalance.feature.user.domain.usecase.GetUserByEmailUseCase
import br.com.lobolabs.ebalance.feature.user.domain.usecase.GetUserByEmailUseCaseImpl
import org.koin.dsl.module
import feature.user.domain.mapper.UserMapper
import feature.user.domain.mapper.UserMapperImpl

val userModule = module {
    single<UserMapper> { UserMapperImpl() }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<AddUserUseCase> { AddUserUseCaseImpl(get()) }
    single<GetUserByEmailUseCase> { GetUserByEmailUseCaseImpl(get()) }
}
