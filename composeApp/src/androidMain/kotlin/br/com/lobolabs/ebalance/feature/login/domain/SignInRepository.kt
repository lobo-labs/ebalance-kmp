package br.com.lobolabs.ebalance.feature.login.domain

import feature.auth.data.response.SignInResponse
import kotlinx.coroutines.flow.Flow

interface SignInRepository {
    suspend fun signIn(email: String, password: String): Flow<SignInResponse>
}