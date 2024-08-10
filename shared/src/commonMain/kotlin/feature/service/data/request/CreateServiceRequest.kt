package feature.service.data.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateServiceRequest(
    var companyId: Long,
    var name: String,
    var price: Double
)
