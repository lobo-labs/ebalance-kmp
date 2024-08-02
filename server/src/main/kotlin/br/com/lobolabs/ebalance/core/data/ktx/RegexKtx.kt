package br.com.lobolabs.ebalance.backend.core.util.ktx

import br.com.lobolabs.ebalance.core.data.model.Patterns

fun String.matchCpfRegex(): Boolean {
    val pattern = Patterns.CPF.toRegex()
    return this.matches(pattern)
}

fun String.matchCnpjRegex(): Boolean {
    val pattern = Patterns.CNPJ.toRegex()
    return this.matches(pattern)
}

fun String.matchPhoneRegex(): Boolean {
    val pattern = Patterns.PHONE.toRegex()
    return this.matches(pattern)
}

fun String.matchBirthRegex(): Boolean {
    val pattern = Patterns.BIRTH.toRegex()
    return this.matches(pattern)
}

fun String.matchEmailRegex(): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS.toRegex()
    return this.matches(pattern)
}
