package feature.relation.data.model

import kotlinx.serialization.Serializable

@Serializable
class RelationRoles(
    val canGet: Boolean,
    val canAdd: Boolean,
    val canEdit: Boolean,
    val canDelete: Boolean
)