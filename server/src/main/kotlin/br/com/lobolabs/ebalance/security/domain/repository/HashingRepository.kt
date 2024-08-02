package br.com.lobolabs.ebalance.security.domain.repository

import br.com.lobolabs.ebalance.security.data.SaltedHash

interface HashingRepository {
    fun generateSaltedHash(
        value: String,
        saltedLength: Int = 32
    ): SaltedHash

    fun verify(value: String, saltedHash: SaltedHash): Boolean
}


