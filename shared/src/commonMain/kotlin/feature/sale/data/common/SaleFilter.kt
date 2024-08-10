package br.com.lobolabs.ebalance.backend.entity.sale.data.model.common

import kotlinx.serialization.Serializable

@Serializable
enum class SaleFilter {
    ALL,
    PAID,
    UNPAID,
    CANCELLED
}
