package br.com.lobolabs.ebalance.backend.entity.cash_in.di

import br.com.lobolabs.ebalance.feature.cashin.data.repository.CashInRepositoryImpl
import br.com.lobolabs.ebalance.feature.cashin.domain.CashInRepository
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.AddCashInUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.AddCashInUseCaseImpl
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.CancelCashInUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.CancelCashInUseCaseImpl
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.CancelCashInsBySaleUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.CancelCashInsBySaleUseCaseImpl
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.CancelCashInsUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.CancelCashInsUseCaseImpl
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.GetCashInByIdUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.GetCashInByIdUseCaseImpl
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.GetCashInsByCompanyUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.GetCashInsByCompanyUseCaseImpl
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.GetCashInsBySaleUseCase
import br.com.lobolabs.ebalance.feature.cashin.domain.usecase.GetCashInsBySaleUseCaseImpl
import org.koin.dsl.module

val cashInModule = module {
    single<CashInRepository> { CashInRepositoryImpl(get()) }
    single<AddCashInUseCase> { AddCashInUseCaseImpl(get(), get()) }
    single<CancelCashInsBySaleUseCase> { CancelCashInsBySaleUseCaseImpl(get()) }
    single<CancelCashInUseCase> { CancelCashInUseCaseImpl(get(), get()) }
    single<CancelCashInsUseCase> { CancelCashInsUseCaseImpl(get()) }
    single<GetCashInByIdUseCase> { GetCashInByIdUseCaseImpl(get()) }
    single<GetCashInsByCompanyUseCase> { GetCashInsByCompanyUseCaseImpl(get()) }
    single<GetCashInsBySaleUseCase> { GetCashInsBySaleUseCaseImpl(get()) }
}
