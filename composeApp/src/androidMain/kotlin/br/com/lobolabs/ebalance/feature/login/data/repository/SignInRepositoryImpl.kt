package br.com.lobolabs.ebalance.feature.login.data.repository

import br.com.lobolabs.ebalance.feature.login.data.api.SignInApi
import br.com.lobolabs.ebalance.feature.login.domain.SignInRepository
import feature.auth.data.request.SignInRequest
import feature.auth.data.response.SignInResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SignInRepositoryImpl(
    private val api: SignInApi,
    private val dispatcher: CoroutineDispatcher
): SignInRepository {
    override suspend fun signIn(email: String, password: String): Flow<SignInResponse> = flow {
        emit(api.signIn(SignInRequest(email, password)))
    }.flowOn(dispatcher)
}