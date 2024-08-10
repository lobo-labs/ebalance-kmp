package br.com.lobolabs.ebalance.feature.login.domain.usecase

import br.com.lobolabs.ebalance.feature.login.domain.SignInRepository
import feature.auth.domain.model.SignInModel
import feature.auth.domain.mapper.SignInMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

interface SignInUseCase {
    suspend operator fun invoke(email: String, password: String): Flow<SignInModel>
}

class SignInUseCaseImpl(
    private val repository: SignInRepository,
    private val mapper: SignInMapper,
    private val dispatcher: CoroutineDispatcher
) : SignInUseCase {
    override suspend fun invoke(email: String, password: String) =
        repository.signIn(email, password).map { mapper.map(it) }.flowOn(dispatcher)
}