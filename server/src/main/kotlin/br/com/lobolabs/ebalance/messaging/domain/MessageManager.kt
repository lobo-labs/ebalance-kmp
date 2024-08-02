package br.com.lobolabs.ebalance.messaging.domain

import br.com.lobolabs.ebalance.core.environment.EnvironmentManager
import br.com.lobolabs.ebalance.messaging.data.SendgridRequest
import com.sendgrid.Method
import com.sendgrid.Request
import com.sendgrid.Response
import com.sendgrid.SendGrid
import com.sendgrid.helpers.mail.Mail
import com.sendgrid.helpers.mail.objects.Content
import com.sendgrid.helpers.mail.objects.Email
import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber

interface MessageManager {
    fun sendSms(message: String, phone: String): Message
    fun sendWhatsapp(message: String, phone: String): Message
    fun sendEmail(request: SendgridRequest, isInternal: Boolean = false): Response
}

class MessageManagerImpl(
    env: EnvironmentManager
) : MessageManager {

    private val twilioEnvData = env.getTwilioData()
    private val sendgridEnvData = env.getSendgridData()

    private val sendGrid = SendGrid(sendgridEnvData.key)

    init {
        Twilio.init(twilioEnvData.accountId, twilioEnvData.authToken)
    }

    override fun sendSms(message: String, phone: String): Message {
        val sender = PhoneNumber("+18129432990")
        val formattedPhone = if (phone.startsWith("+")) phone else "+55$phone"
        val receiver = PhoneNumber(formattedPhone)
        return Message.creator(receiver, sender, message).create()
    }

    override fun sendWhatsapp(message: String, phone: String): Message {
        val sender = PhoneNumber("whatsapp:+18129432990")
        val formattedPhone = if (phone.startsWith("+")) phone else "+55$phone"
        val receiver = PhoneNumber("whatsapp:$formattedPhone")
        return Message.creator(receiver, sender, message).create()
    }

    override fun sendEmail(request: SendgridRequest, isInternal: Boolean): Response {

        val from = if (isInternal) {
            Email("lobolabs.co@gmail.com")
        } else {
            Email(sendgridEnvData.email)
        }

        val receiver = Email(request.to)

        val content = Content("text/html", request.content)
        val mail = Mail(from, request.subject, receiver, content)


        val emailRequest = Request()

        emailRequest.method = Method.POST
        emailRequest.endpoint = "mail/send"
        emailRequest.body = mail.build()

        return sendGrid.api(emailRequest)

    }
}
