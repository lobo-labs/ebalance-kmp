package feature.auth.domain

import user.domain.model.User

data class SignInResult(
    val user: User,
    val token: String
)