package br.com.lobolabs.ebalance.feature.auth.domain.route

import br.com.lobolabs.ebalance.core.data.ktx.getSuccessData
import br.com.lobolabs.ebalance.core.data.ktx.runOnError
import br.com.lobolabs.ebalance.core.data.ktx.sendResponse
import br.com.lobolabs.ebalance.feature.auth.domain.usecase.ValidatePasswordUseCase
import br.com.lobolabs.ebalance.feature.auth.domain.validator.SignInValidator
import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import br.com.lobolabs.ebalance.feature.user.domain.usecase.GetUserByEmailUseCase
import br.com.lobolabs.ebalance.feature.user.domain.util.mapToUserResponse
import br.com.lobolabs.ebalance.security.domain.usecase.GenerateJwtUseCase
import core.AppError
import core.AppErrorCode
import feature.auth.data.request.SignInRequest
import feature.auth.data.response.SignInResponse
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import org.koin.ktor.ext.inject

fun Route.signInRoute() {

//    val firebase by inject<FirebaseManager>()

    val getUserByEmailUseCase by inject<GetUserByEmailUseCase>()
    val validatePasswordUseCase by inject<ValidatePasswordUseCase>()

    val generateJwtUseCase by inject<GenerateJwtUseCase>()

    post("/api/auth/sign-in") {

        val request = try {
            call.receive<SignInRequest>()
        } catch (t: Throwable) {
            call.sendResponse(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.BODY_SIGN_IN_INVALID))
            return@post
        }

        val validateRequest = SignInValidator.isValid(request)
        validateRequest.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error, request)
            return@post
        }

        val getUser = getUserByEmailUseCase.execute(request.email)
        getUser.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error, request)
            return@post
        }

        val user: UserDao = getUser.getSuccessData()

        val validatePassword = validatePasswordUseCase.execute(request.password, user)
        validatePassword.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error, request)
            return@post
        }

        val generateToken = generateJwtUseCase.execute(user)
        generateToken.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error, request)
            return@post
        }
        val token: String = generateToken.getSuccessData()

        val response = SignInResponse(
            user = user.mapToUserResponse(),
            token = token
        )

        call.sendResponse(HttpStatusCode.OK.value, response, request, isError = false)
    }
}
