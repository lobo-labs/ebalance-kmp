package signin.data.model.request

//import br.com.lobolabs.ebalance.backend.core.domain.model.ApiStatus
//import br.com.lobolabs.ebalance.backend.core.domain.model.AppError
//import br.com.lobolabs.ebalance.backend.core.domain.model.AppErrorCode
//import br.com.lobolabs.ebalance.backend.core.util.ktx.matchEmailRegex
//import io.ktor.http.*
//import kotlinx.serialization.Serializable
//
//@Serializable
data class SignInRequest(
    val email: String,
    val password: String
) /*{
    fun isValid(): ApiStatus<String> {

        if (!email.matchEmailRegex()) {
            return ApiStatus.Error(HttpStatusCode.BadRequest, AppError(AppErrorCode.AUTH_EMAIL_INVALID))
        }

        if (password.length < 8) {
            return ApiStatus.Error(HttpStatusCode.BadRequest, AppError(AppErrorCode.AUTH_PASSWORD_INVALID))
        }

        return ApiStatus.Success("Objeto de login valido!")
    }
}
*/