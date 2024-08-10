package feature.auth.domain.mapper

import core.mapper.Mapper
import feature.auth.data.response.SignInResponse
import feature.auth.domain.model.SignInModel
import feature.user.domain.mapper.UserMapper

interface SignInMapper: Mapper<SignInResponse, SignInModel>

class SignInMapperImpl(
    private val userMapper: UserMapper
): SignInMapper {
    override fun map(from: SignInResponse) = SignInModel(
        user = userMapper.map(from.user),
        token = from.token
    )
}
