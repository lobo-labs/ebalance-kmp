package feature.receiver.data.response

import kotlinx.serialization.Serializable

@Serializable
data class ReceiverReferenceResponse(
    var id: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?
)