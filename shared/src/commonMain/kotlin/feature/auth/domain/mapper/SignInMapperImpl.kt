package feature.auth.domain.mapper

import core.mapper.Mapper
import feature.auth.data.response.SignInResponse
import feature.auth.domain.SignInResult
import user.domain.mapper.UserMapper
import user.domain.mapper.UserMapperImpl

interface SignInMapper: Mapper<SignInResponse, SignInResult>

class SignInMapperImpl(
    private val userMapper: UserMapper
): SignInMapper {
    override fun map(from: SignInResponse) = SignInResult(
        user = userMapper.map(from.user),
        token = from.token
    )
}
