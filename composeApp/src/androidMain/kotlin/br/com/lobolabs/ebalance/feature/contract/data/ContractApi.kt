package br.com.lobolabs.ebalance.feature.contract.data

import feature.contract.data.response.ContractResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get


interface ContractApi {
    suspend fun getContracts(companyId: String): List<ContractResponse>
}

class ContractApiImpl(
    private val client: HttpClient
) : ContractApi {
    override suspend fun getContracts(companyId: String): List<ContractResponse> {
        return client
            .get("https://ebalance-api.lobolabs.com.br/api/companies/$companyId/contracts")
            .body()
    }
}
