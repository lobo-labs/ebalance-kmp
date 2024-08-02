package feature.relation.data.model

import kotlinx.serialization.Serializable

@Serializable
class RelationFinancialRoles(
    val canGet: Boolean,
    val canView: Boolean,
    val canAdd: Boolean,
    val canEdit: Boolean,
    val canDelete: Boolean,
)
