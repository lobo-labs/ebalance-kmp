package br.com.lobolabs.ebalance.feature.contract.domain

import feature.contract.data.response.ContractResponse
import kotlinx.coroutines.flow.Flow

interface  ContractRepository {
    suspend fun getContracts(companyId: String): Flow<List<ContractResponse>>
}