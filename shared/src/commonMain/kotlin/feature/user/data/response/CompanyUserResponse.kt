package feature.user.data.response

import feature.relation.data.model.RelationType
import kotlinx.serialization.Serializable

@Serializable
data class CompanyUserResponse(
    var id: Long,
    var cpf: String?,
    var name: String,
    var email: String,
    var phone: String,
    var relation: RelationType,
)