package feature.service.data.common

import kotlinx.serialization.Serializable

@Serializable
enum class ServiceSearchType {
    NONE,
    NAME,
    PRICE
}
