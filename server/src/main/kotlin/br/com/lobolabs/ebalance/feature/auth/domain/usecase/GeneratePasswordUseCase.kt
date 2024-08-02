package br.com.lobolabs.ebalance.feature.auth.domain.usecase

import br.com.lobolabs.ebalance.core.data.model.Constants
import java.util.*

interface GeneratePasswordUseCase {
    fun execute(length: Int = 8): String
}

class GeneratePasswordUseCaseImpl : GeneratePasswordUseCase {
    override fun execute(length: Int): String {
        val password = StringBuilder()
        val characterSet = Constants.CHARSET_SYMBOLS +
                Constants.CHARSET_NUMBERS +
                Constants.CHARSET_ALPHABET +
                Constants.CHARSET_ALPHABET_UPPERCASE
        val random = Random(System.nanoTime())
        for (i in 0 until length) {
            val char = random.nextInt(characterSet.length)
            password.append(characterSet[char])
        }
        return password.toString()
    }
}
