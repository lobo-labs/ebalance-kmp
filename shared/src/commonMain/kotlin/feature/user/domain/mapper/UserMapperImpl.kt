package feature.user.domain.mapper

import core.mapper.Mapper
import feature.user.data.response.UserResponse
import feature.user.domain.model.UserModel

interface UserMapper: Mapper<UserResponse, UserModel>

class UserMapperImpl: UserMapper {
    override fun map(from: UserResponse) = UserModel(
        id = from.id,
        cpf = from.cpf,
        name = from.name,
        email = from.email,
        phone = from.phone
    )
}
