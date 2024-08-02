package br.com.lobolabs.ebalance.feature.login.data.api

import feature.auth.data.request.SignInRequest
import feature.auth.data.response.SignInResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

interface SignInApi {
    suspend fun signIn(request: SignInRequest): SignInResponse
}

class SignInApiImpl(
    private val client: HttpClient
) : SignInApi {
    override suspend fun signIn(request: SignInRequest): SignInResponse {
        return client.post("https://ebalance-api.lobolabs.com.br/api/auth/sign-in") {
            setBody(request)
        }.body<SignInResponse>()
    }
}