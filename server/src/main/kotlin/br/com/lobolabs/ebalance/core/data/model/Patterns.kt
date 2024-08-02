package br.com.lobolabs.ebalance.core.data.model

import java.util.regex.Pattern

object Patterns {
    val CPF: Pattern = Pattern.compile("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")
    val CNPJ: Pattern = Pattern.compile("[0-9]{2}.[0-9]{3}.[0-9]{3}\\/[0-9]{4}-[0-9]{2}")
    val BIRTH: Pattern = Pattern.compile( "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}")
    val PHONE: Pattern = Pattern.compile("\\([0-9]{2}\\) [0-9]{4,5}-[0-9]{4}")
    val EMAIL_ADDRESS: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
}