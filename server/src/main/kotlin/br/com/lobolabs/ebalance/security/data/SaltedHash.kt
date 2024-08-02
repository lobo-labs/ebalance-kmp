package br.com.lobolabs.ebalance.security.data

data class SaltedHash(
    val hash: String,
    val salt: String
)
