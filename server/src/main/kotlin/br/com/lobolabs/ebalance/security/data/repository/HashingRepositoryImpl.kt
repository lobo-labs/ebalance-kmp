package br.com.lobolabs.ebalance.security.data.repository

import br.com.lobolabs.ebalance.security.data.SaltedHash
import br.com.lobolabs.ebalance.security.domain.repository.HashingRepository
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils
import java.security.SecureRandom

class HashingRepositoryImpl : HashingRepository {
    override fun generateSaltedHash(value: String, saltedLength: Int): SaltedHash {
        val salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltedLength)
        val saltAsHex = Hex.encodeHexString(salt)
        val hash = DigestUtils.sha256Hex("$saltAsHex$value")
        return SaltedHash(hash, saltAsHex)
    }

    override fun verify(value: String, saltedHash: SaltedHash): Boolean {
        return DigestUtils.sha256Hex(saltedHash.salt + value) == saltedHash.hash
    }
}