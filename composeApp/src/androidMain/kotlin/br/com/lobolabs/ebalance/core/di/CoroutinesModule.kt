package br.com.lobolabs.ebalance.core.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val DISPATCHER_DEFAULT = "DISPATCHER_DEFAULT"
const val DISPATCHER_IO = "DISPATCHER_IO"
const val DISPATCHER_MAIN = "DISPATCHER_MAIN"
const val DISPATCHER_UNCONFINED = "DISPATCHER_UNCONFINED"

val coroutinesModule = module {
    single(qualifier = named(DISPATCHER_DEFAULT)) { Dispatchers.Default }
    single(qualifier = named(DISPATCHER_IO)) { Dispatchers.IO }
    single(qualifier = named(DISPATCHER_MAIN)) { Dispatchers.Main }
    single(qualifier = named(DISPATCHER_UNCONFINED)) { Dispatchers.Unconfined }
}
