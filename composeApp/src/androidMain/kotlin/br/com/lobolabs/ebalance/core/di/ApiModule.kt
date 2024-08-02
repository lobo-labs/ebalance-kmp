package br.com.lobolabs.ebalance.core.di

import br.com.lobolabs.ebalance.feature.login.data.api.SignInApi
import br.com.lobolabs.ebalance.feature.login.data.api.SignInApiImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val apiModule = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    json = Json { ignoreUnknownKeys = true },
                    contentType = ContentType.Any
                )
            }
        }
    }

    single<SignInApi> { SignInApiImpl(get()) }
}
