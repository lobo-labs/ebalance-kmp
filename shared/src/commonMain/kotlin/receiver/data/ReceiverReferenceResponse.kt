package receiver.data

import kotlinx.serialization.Serializable

@Serializable
data class ReceiverReferenceResponse(
    var id: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?
)