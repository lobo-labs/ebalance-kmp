package br.com.lobolabs.ebalance.security.data.model

import br.com.lobolabs.ebalance.core.environment.TokenEnvConfig

data class TokenConfig(
    val issuer: String,
    val audience: String,
    val secret: String,
    val expiresIn: Long
) {
    constructor(tokenEnvConfig: TokenEnvConfig): this(
        audience  = tokenEnvConfig.audience,
        issuer = tokenEnvConfig.issuer,
        secret = tokenEnvConfig.secret,
        expiresIn = tokenEnvConfig.expiresIn,
    )
}