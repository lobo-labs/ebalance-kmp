package feature.auth.domain.model

import feature.company.domain.model.CompanyModel
import feature.user.domain.model.UserModel

data class SignUpModel(
    val user: UserModel,
    val company: CompanyModel,
    val password: String
)
