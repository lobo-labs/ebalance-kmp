package br.com.lobolabs.ebalance.core.environment

import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*

object EnvironmentManager {

    private val config = HoconApplicationConfig(ConfigFactory.load())

    fun isDev() = config.property("environment").getString() == "dev"

    fun getAppUrl(): String = config.property("app.web").getString()

    fun getDatabase() = DatabaseEnvData(
        driver = config.property("database.driver").getString(),
        url = config.property("database.url").getString()
    )

    fun getSendgridData() = SendgridEnvData(
        key = config.property("sendgrid.key").getString(),
        email = config.property("sendgrid.email").getString()
    )

    fun getTwilioData() = TwilioEnvData(
        accountId = config.property("twilio.id").getString(),
        authToken = config.property("twilio.token").getString()
    )

    fun getRedeData() = RedeEnvData(
        url = config.property("rede.url").getString(),
        pv = config.property("rede.pv").getString().toInt(),
        token = config.property("rede.token").getString()
    )

    fun getTokenConfig() = TokenEnvConfig(
        audience = config.property("jwt.audience").getString(),
        issuer = config.property("jwt.issuer").getString(),
        secret = config.property("jwt.secret").getString(),
        realm = config.property("jwt.realm").getString(),
        expiresIn = 1000L * 60L * 60L * 24L,
    )

    fun runContractJob(): Boolean {
        return config.property("jobs.contract").getString().toBoolean()
    }

    fun runAudit(): Boolean {
        return config.property("audit.logs").getString().toBoolean()
    }

    fun cardPaymentEnabled(): Boolean {
        return config.property("payment.enabled").getString().toBoolean()
    }
}

class DatabaseEnvData(
    val driver: String,
    val url: String
)

class SendgridEnvData(
    val key: String,
    val email: String
)

class TwilioEnvData(
    val accountId: String,
    val authToken: String
)

class RedeEnvData(
    val url: String,
    val pv: Int,
    val token: String
)

class TokenEnvConfig(
    val issuer: String,
    val audience: String,
    val secret: String,
    val realm: String,
    val expiresIn: Long
)
