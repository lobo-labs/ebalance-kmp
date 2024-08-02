package feature.provider

import feature.provider.domain.Provider

object ProviderFactory {
    fun getProviders() = (0..10).map { getProvider(it.toLong()) }

    fun getProvider(id: Long) = Provider(
        id = id,
        name = "LoboLabs",
        email = "loboneto@lobolabs.com.br",
        phone = "(84) 99615-1389",
        address = null
    )
}