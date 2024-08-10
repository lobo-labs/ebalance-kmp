package br.com.lobolabs.ebalance.backend.entity.sale.data.model.common

import kotlinx.serialization.Serializable

@Serializable
enum class SaleSearchType {
    NONE,
    CUSTOMER,
    ENTRY_DATE,
    FINISH_DATE,
    NOTES,
    RECEIVER,
    TOTAL
}
