package feature.auth.domain.mapper

import core.mapper.Mapper
import feature.auth.data.response.SignInResponse
import feature.auth.domain.SignInResult
import user.domain.mapper.UserMapper

class SignInMapper(
    private val userMapper: UserMapper
): Mapper<SignInResponse, SignInResult> {
    override fun map(from: SignInResponse) = SignInResult(
        user = userMapper.map(from.user),
        token = from.token
    )
}
