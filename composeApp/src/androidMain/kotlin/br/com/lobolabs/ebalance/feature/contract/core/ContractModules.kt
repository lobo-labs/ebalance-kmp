package br.com.lobolabs.ebalance.feature.contract.core

import br.com.lobolabs.ebalance.feature.contract.data.ContractApi
import br.com.lobolabs.ebalance.feature.contract.data.ContractApiImpl
import br.com.lobolabs.ebalance.feature.contract.data.ContractRepositoryImpl
import br.com.lobolabs.ebalance.feature.contract.domain.ContractRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val contractModule = module {
    single<ContractApi> { ContractApiImpl(get()) }
    single<ContractRepository> { ContractRepositoryImpl(get(), Dispatchers.IO) }
}