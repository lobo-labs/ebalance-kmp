package br.com.lobolabs.ebalance.security.data.model

import br.com.lobolabs.ebalance.feature.user.data.database.UserDao

data class TokenClaim(
    val name: String,
    val value: String
) {

    companion object {

        fun getInstance(userDao: UserDao): List<TokenClaim> {
            return listOf(
                TokenClaim("id", userDao.id.toString()),
                TokenClaim("cpf", userDao.cpf),
                TokenClaim("name", userDao.name),
                TokenClaim("email", userDao.email),
                TokenClaim("passStart", getFirst5(userDao.password)),
                TokenClaim("passLast", getLast5(userDao.password)),
                TokenClaim("type", userDao.type)
            )
        }

        private fun getFirst5(string: String): String {
            return string.replaceRange(5, string.length, "")
        }

        private fun getLast5(string: String): String {
            return string.replaceRange(0, string.length - 5, "")
        }
    }
}
