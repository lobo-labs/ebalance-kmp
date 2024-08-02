package user.domain.mapper

import core.mapper.Mapper
import user.data.model.UserResponse
import user.domain.model.User

class UserMapper: Mapper<UserResponse, User> {
    override fun map(from: UserResponse) = User(
        id = from.id,
        cpf = from.cpf,
        name = from.name,
        email = from.email,
        phone = from.phone
    )
}
