package feature.service.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateServiceRequest(
    var name: String,
    var price: Double
)
