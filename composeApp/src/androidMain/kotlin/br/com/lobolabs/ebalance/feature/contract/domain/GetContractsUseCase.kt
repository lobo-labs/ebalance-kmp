package br.com.lobolabs.ebalance.feature.contract.domain

import feature.contract.domain.model.ContractModel
import feature.contract.domain.mapper.ContractMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GetContractsUseCase {
    suspend operator fun invoke(): Flow<List<ContractModel>>
}

class GetContractsUseCaseImpl(
    private val repository: ContractRepository,
    private val mapper: ContractMapper,
    private val dispatcher: CoroutineDispatcher
) : GetContractsUseCase {
    override suspend fun invoke() = flow<List<ContractModel>> {
        emit(listOf())
    }
}