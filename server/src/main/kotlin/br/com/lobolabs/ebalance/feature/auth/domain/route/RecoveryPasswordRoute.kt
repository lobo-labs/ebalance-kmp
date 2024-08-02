package br.com.lobolabs.ebalance.feature.auth.domain.route

import br.com.lobolabs.ebalance.backend.core.domain.constants.CallParameters
import br.com.lobolabs.ebalance.backend.core.util.ktx.matchEmailRegex
import br.com.lobolabs.ebalance.core.data.ktx.getFirstName
import br.com.lobolabs.ebalance.core.data.ktx.getSuccessData
import br.com.lobolabs.ebalance.core.data.ktx.runOnError
import br.com.lobolabs.ebalance.core.data.ktx.sendResponse
import br.com.lobolabs.ebalance.core.data.model.response.SuccessResponse
import br.com.lobolabs.ebalance.core.environment.EnvironmentManager
import br.com.lobolabs.ebalance.feature.user.domain.usecase.GetUserByEmailUseCase
import br.com.lobolabs.ebalance.messaging.SendgridEmailUseCase
import br.com.lobolabs.ebalance.messaging.domain.EmailFactory
import br.com.lobolabs.ebalance.security.domain.usecase.GenerateJwtUseCase
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.routing.Route
import io.ktor.server.routing.put
import org.koin.ktor.ext.inject

fun Route.recoveryPasswordRoute() {

    // val firebase by inject<FirebaseManager>()
    val environmentManager by inject<EnvironmentManager>()

    val getUserByEmailUseCase by inject<GetUserByEmailUseCase>()
    val sendgridEmailUseCase by inject<SendgridEmailUseCase>()
    val generateJwtUseCase by inject<GenerateJwtUseCase>()

    val paramUserEmail = CallParameters.USER_EMAIL

    put("/api/auth/users/{$paramUserEmail}/recovery-password") {

        val email = call.parameters[paramUserEmail] ?: run {
            call.sendResponse(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.PARAMS_USER_EMAIL_REQUIRED))
            return@put
        }

        if (!email.matchEmailRegex()) {
            call.sendResponse(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.PARAMS_USER_EMAIL_INVALID))
            return@put
        }

        val getUser = getUserByEmailUseCase.execute(email)
        getUser.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error)
            return@put
        }
        val userDao = getUser.getSuccessData()

        val generateToken = generateJwtUseCase.execute(userDao, temporaryToken = true)
        generateToken.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error)
            return@put
        }
        val token = generateToken.getSuccessData()

        val appUrl = environmentManager.getAppUrl()
        val recoveryPasswordUrl = "$appUrl/#/recovery-password/$token"

        val sendEmailRequest = EmailFactory.recoveryPasswordEmail(
            userDao.email,
            userDao.name.getFirstName(),
            recoveryPasswordUrl,
            appUrl
        )

        val sendEmail = sendgridEmailUseCase.execute(sendEmailRequest)
        sendEmail.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error)
            return@put
        }

        val response = SuccessResponse("Recuperação de senha enviada no e-mail!")
        call.sendResponse(HttpStatusCode.OK.value, response, isError = false)
    }
}
