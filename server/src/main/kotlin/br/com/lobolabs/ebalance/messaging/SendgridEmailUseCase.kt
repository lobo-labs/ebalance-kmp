package br.com.lobolabs.ebalance.messaging

import br.com.lobolabs.ebalance.core.data.model.response.SuccessResponse
import br.com.lobolabs.ebalance.messaging.data.SendgridRequest
import br.com.lobolabs.ebalance.messaging.domain.MessageManager
import core.ApiStatus
import core.AppError
import core.AppErrorCode
import io.ktor.http.HttpStatusCode

interface SendgridEmailUseCase {
    suspend fun execute(request: SendgridRequest, isInternal: Boolean = false): ApiStatus<SuccessResponse>
}

class SendgridEmailUseCaseImpl(
    private val messageManager: MessageManager
) : SendgridEmailUseCase {

    override suspend fun execute(request: SendgridRequest, isInternal: Boolean): ApiStatus<SuccessResponse> {

        val response = try {
            messageManager.sendEmail(request, isInternal)
        } catch (t: Throwable) {
            return ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.GENERIC_ERROR, t))
        }

        return when (response.statusCode) {
            200, 202 -> {
                ApiStatus.Success(
                    SuccessResponse("Email enviado com sucesso!")
                )
            }

            else -> {
                try {
                    val error = response.body.toString()
                    ApiStatus.Error(
                        HttpStatusCode.InternalServerError.value,
                        AppError(AppErrorCode.GENERIC_ERROR.ordinal, error, null)
                    )
                } catch (t: Throwable) {
                    ApiStatus.Error(HttpStatusCode.InternalServerError.value, AppError(AppErrorCode.GENERIC_ERROR, t))
                }
            }
        }
    }
}
