package feature.provider

import feature.expense.domain.ProviderReference
import feature.provider.domain.ProviderModel

object ProviderFactory {
    fun getProviders() = (0..10).map { getProvider(it.toLong()) }

    fun getProvider(id: Long) = ProviderModel(
        id = id,
        companyId = id,
        name = "LoboLabs",
        cnpj = "55.315.153/0001-55",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389",
        address = null,
        isActive = true
    )

    fun getReference(id: Long) = ProviderReference(
        id = id,
        name = "LoboLabs",
        cnpj = "55.315.153/0001-55",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389"
    )
}