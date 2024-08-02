package br.com.lobolabs.ebalance.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DateFilter(
    val start: Long,
    val end: Long
)