package feature.auth.domain.model

import feature.user.domain.model.UserModel

data class SignInModel(
    val user: UserModel,
    val token: String
)