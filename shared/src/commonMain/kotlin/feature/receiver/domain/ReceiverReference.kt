package feature.receiver.domain

data class ReceiverReference(
    var id: Long,
    var name: String,
    var cnpj: String?,
    var email: String?,
    var phone: String?
)