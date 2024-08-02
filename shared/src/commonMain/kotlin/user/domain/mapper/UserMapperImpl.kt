package user.domain.mapper

import core.mapper.Mapper
import feature.auth.data.response.SignInResponse
import feature.auth.domain.SignInResult
import user.data.model.UserResponse
import user.domain.model.User

interface UserMapper: Mapper<UserResponse, User>

class UserMapperImpl: UserMapper {
    override fun map(from: UserResponse) = User(
        id = from.id,
        cpf = from.cpf,
        name = from.name,
        email = from.email,
        phone = from.phone
    )
}
