package br.com.lobolabs.ebalance.feature.auth.domain.route

import br.com.lobolabs.ebalance.backend.entity.user.domain.use_case.AddUserUseCase
import br.com.lobolabs.ebalance.core.data.ktx.getFirstName
import br.com.lobolabs.ebalance.core.data.ktx.getSuccessData
import br.com.lobolabs.ebalance.core.data.ktx.runOnError
import br.com.lobolabs.ebalance.core.data.ktx.sendResponse
import br.com.lobolabs.ebalance.core.environment.EnvironmentManager
import br.com.lobolabs.ebalance.feature.auth.data.SignUpValidator
import br.com.lobolabs.ebalance.feature.company.CompanyDao
import br.com.lobolabs.ebalance.feature.company.domain.usecase.AddCompanyUseCase
import br.com.lobolabs.ebalance.feature.company.domain.util.mapToCompanyResponse
import br.com.lobolabs.ebalance.feature.relation.domain.usecase.AddCompanyUserRelationUseCase
import br.com.lobolabs.ebalance.feature.user.data.database.UserDao
import br.com.lobolabs.ebalance.feature.user.domain.util.mapToUserResponse
import br.com.lobolabs.ebalance.messaging.SendgridEmailUseCase
import br.com.lobolabs.ebalance.messaging.domain.EmailFactory
import br.com.lobolabs.ebalance.security.data.SaltedHash
import br.com.lobolabs.ebalance.security.domain.usecase.GenerateHashUseCase
import br.com.lobolabs.ebalance.security.domain.usecase.GenerateJwtUseCase
import core.AppError
import core.AppErrorCode
import feature.auth.data.request.SignUpRequest
import feature.auth.data.response.SignUpResponse
import feature.relation.data.model.RelationType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import org.koin.ktor.ext.inject
import org.ktorm.database.Database

fun Route.signUpRoute() {

    val database by inject<Database>()

//    val firebase by inject<FirebaseManager>()

    val environment by inject<EnvironmentManager>()

    val addUserUseCase by inject<AddUserUseCase>()
    val addCompanyUseCase by inject<AddCompanyUseCase>()
    val addCompanyUserRelationUseCase by inject<AddCompanyUserRelationUseCase>()

    val sendgridEmailUseCase by inject<SendgridEmailUseCase>()

    val generateHashUseCase by inject<GenerateHashUseCase>()
    val generateJwtUseCase by inject<GenerateJwtUseCase>()

    post("/api/auth/sign-up") {

        val request = try {
            call.receive<SignUpRequest>()
        } catch (t: Throwable) {
            call.sendResponse(HttpStatusCode.BadRequest.value, AppError(AppErrorCode.BODY_SIGN_UP_INVALID))
            return@post
        }

        val validateRequest = SignUpValidator.isValid(request)
        validateRequest.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error, request)
            return@post
        }

        val generateHash = generateHashUseCase.execute(request.password)
        generateHash.runOnError { statusCode, error ->
            call.sendResponse(statusCode, error, request)
            return@post
        }
        val hash: SaltedHash = generateHash.getSuccessData()

        database.useTransaction { transaction ->

            val addUser = addUserUseCase.execute(request.user, hash)
            addUser.runOnError { statusCode, error ->
                transaction.rollback()
                call.sendResponse(statusCode, error, request)
                return@post
            }
            val user: UserDao = addUser.getSuccessData()

            val addCompany = addCompanyUseCase.execute(request.company)
            addCompany.runOnError { statusCode, error ->
                transaction.rollback()
                call.sendResponse(statusCode, error, request)
                return@post
            }
            val company: CompanyDao = addCompany.getSuccessData()

            val addRelation = addCompanyUserRelationUseCase.execute(user.id, company.id, RelationType.OWNER)
            addRelation.runOnError { statusCode, error ->
                transaction.rollback()
                call.sendResponse(statusCode, error, request)
                return@post
            }

            val sendEmailRequest = EmailFactory.welcomeEmail(user.email, user.name.getFirstName(), environment.getAppUrl())

            val sendEmail = sendgridEmailUseCase.execute(sendEmailRequest)
            sendEmail.runOnError { _, _ ->
                val response = AppError(AppErrorCode.SIGN_UP_SUCCESS_NO_EMAIL)
                call.sendResponse(HttpStatusCode.OK.value, response, request)
                return@post
            }

            val generateToken = generateJwtUseCase.execute(user)
            generateToken.runOnError { statusCode, error ->
                call.sendResponse(statusCode, error, request)
                return@post
            }
            val token = generateToken.getSuccessData()

            val response = SignUpResponse(user.mapToUserResponse(), company.mapToCompanyResponse(), token)
            call.sendResponse(HttpStatusCode.OK.value, response, request, isError = false)
        }
    }
}
