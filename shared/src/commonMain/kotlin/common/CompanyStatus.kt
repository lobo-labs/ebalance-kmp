package common

import kotlinx.serialization.Serializable

@Serializable
enum class CompanyStatus(
    var value: String
) {
    PENDING("Cadastro pendente"),
    BLOCKED("Cadastro bloqueado"),
    INACTIVE("Cadastro inativo"),
    OVERDUE("Inadimplente"),
    ACTIVE("Cadastro ativo")
}
