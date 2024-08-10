package feature.user.data.common

import kotlinx.serialization.Serializable

@Serializable
enum class UserType {
    SYSTEM_ADMIN,
    USER,
}
