package br.com.lobolabs.ebalance.core.data.model

enum class RequestPaginationOder {
    NAME_ASC, // BAIXO - CIMA
    NAME_DESC, // CIMA - BAIXO
    ENTRY_DATE_ASC,
    ENTRY_DATE_DESC,
    FINISH_DATE_ASC,
    FINISH_DATE_DESC,
    CREATED_DATE_ASC,
    CREATED_DATE_DESC,
}