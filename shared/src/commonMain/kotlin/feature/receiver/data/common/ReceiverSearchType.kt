package feature.receiver.data.common

import kotlinx.serialization.Serializable

@Serializable
enum class ReceiverSearchType {
    NONE,
    NAME,
    PHONE
}
