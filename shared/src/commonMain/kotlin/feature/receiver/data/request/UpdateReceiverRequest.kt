package feature.receiver.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateReceiverRequest(
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?,
    //var address: String?
)
