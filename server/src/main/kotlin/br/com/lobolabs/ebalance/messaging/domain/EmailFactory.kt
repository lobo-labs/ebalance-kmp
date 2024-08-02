package br.com.lobolabs.ebalance.messaging.domain

import br.com.lobolabs.ebalance.messaging.data.SendgridRequest

object EmailFactory {
    fun welcomeEmail(to: String, name: String, appUrl: String) = SendgridRequest(
        to = to,
        subject = "E-Balance - Boas vindas",
        content = """
                <p>Olá, $name</p>
                <p>Seja bem vindo ao <strong><a href="$appUrl">E-Balance</a></strong></p>
                <p>Se precisar de ajuda basta entrar em contato com a gente</p>
                <p>Equipe <strong><a href="$appUrl">E-Balance</a></strong></p>
               """
    )


    fun welcomeEmail(
        to: String,
        name: String,
        password: String,
        appUrl: String
    ) = SendgridRequest(
        to = to,
        subject = "E-Balance - Boas vindas",
        content = """
                <p>Olá, $name</p>
                <p>Seja bem vindo ao <strong><a href="$appUrl">E-Balance</a></strong></p>
                <p>Sua senha provisória é <strong>$password</strong></p>
                <p>Se precisar de ajuda basta entrar em contato com a gente</p>
                <p>Equipe <strong><a href="$appUrl">E-Balance</a></strong></p>
               """
    )


    fun recoveryPasswordEmail(
        to: String,
        name: String,
        link: String,
        appUrl: String
    ) = SendgridRequest(
        to = to,
        subject = "E-Balance - Recuperação de senha",
        content = """
            <p>Olá, $name!"</p> 
            <p>Parece que voce esqueceu sua senha do <strong><a href="$appUrl">E-Balance</a></strong></p>
            <p>Mas não se preocupe, <strong><a href="$link">clique aqui</a></strong> para recuperar sua senha</p>
            <p>Se voce não solicitou essa alteração, por favor ignore este e-mail ou se achar necessário entre em contato para nos informar.</p>
            <p>Este link é válido apenas pelos próximos 30 minutos.</p>
            <p>Equipe <strong><a href="$appUrl">E-Balance</a></strong></p>
                """

    )


}