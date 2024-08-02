package br.com.lobolabs.ebalance.security.data.repository

import br.com.lobolabs.ebalance.security.data.model.TokenClaim
import br.com.lobolabs.ebalance.security.data.model.TokenConfig
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

interface TokenRepository {
    fun generate(
        config: TokenConfig,
        claims: List<TokenClaim>,
        temp: Boolean = false
    ): String
}

class TokenRepositoryImpl : TokenRepository {
    override fun generate(
        config: TokenConfig,
        claims: List<TokenClaim>,
        temp: Boolean
    ): String {
        val expires = if (temp) {
            Date(System.currentTimeMillis() + 300000L)
        } else {
            Date(System.currentTimeMillis() + config.expiresIn)
        }
        var token = JWT.create()
            .withAudience(config.audience)
            .withIssuer(config.issuer)
            .withExpiresAt(expires)
        claims.forEach {
            token = token.withClaim(it.name, it.value)
        }
        return token.sign(Algorithm.HMAC256(config.secret))
    }
}
