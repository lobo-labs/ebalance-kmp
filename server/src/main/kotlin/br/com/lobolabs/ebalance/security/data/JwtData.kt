package br.com.lobolabs.ebalance.security.data

import feature.user.data.common.UserType
import io.ktor.server.auth.jwt.*

data class JwtData(
    val id: Long,
    val name: String,
    val cpf: String,
    val email: String,
    val passStart: String,
    val passLast: String,
    val type: UserType
) {

    constructor(principal: JWTPrincipal) : this(
        principal.getClaim("id", Long::class)!!,
        principal.getClaim("name", String::class)!!,
        principal.getClaim("cpf", String::class)!!,
        principal.getClaim("email", String::class)!!,
        principal.getClaim("passStart", String::class)!!,
        principal.getClaim("passLast", String::class)!!,
        UserType.valueOf(principal.getClaim("type", String::class)!!),
    )
}