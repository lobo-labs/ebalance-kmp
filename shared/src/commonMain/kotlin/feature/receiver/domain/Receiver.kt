package feature.receiver.domain

data class Receiver(
    val id: Long,
    val name: String,
    val email: String,
    val phone: String?,
    val address: String?
)
