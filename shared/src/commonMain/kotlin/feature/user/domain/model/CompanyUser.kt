package feature.user.domain.model

import feature.relation.data.model.RelationType

data class CompanyUser(
    var id: Long,
    var cpf: String?,
    var name: String,
    var email: String,
    var phone: String,
    var relation: RelationType,
)