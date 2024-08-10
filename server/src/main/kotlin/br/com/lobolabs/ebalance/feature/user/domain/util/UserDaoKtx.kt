package br.com.lobolabs.ebalance.feature.user.domain.util

import br.com.lobolabs.ebalance.core.data.ktx.formattedCpfOrCnpj
import br.com.lobolabs.ebalance.core.data.ktx.formattedPhone
import br.com.lobolabs.ebalance.feature.relation.data.database.CompanyUserRelationDao
import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import feature.relation.data.model.RelationType
import feature.user.data.response.UserResponse
import feature.user.data.response.CompanyUserResponse

//class UserMapper: Mapper<UserDao, UserResponse>() {
//
//}

fun List<UserDao>.mapToUsers(): List<UserResponse> {
    return this.map { it.mapToUserResponse() }
}

fun UserDao.mapToUserResponse() = UserResponse(
        id,
        cpf.formattedCpfOrCnpj(),
        name,
        email,
        phone.formattedPhone()
    )


fun UserDao.mapToCompanyUser(
    relationDao: CompanyUserRelationDao
): CompanyUserResponse {
    return CompanyUserResponse(
        id,
        cpf.formattedCpfOrCnpj(),
        name,
        email,
        phone.formattedPhone(),
        RelationType.valueOf(relationDao.relationType)
    )
}
