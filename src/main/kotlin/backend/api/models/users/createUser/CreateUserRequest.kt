package backend.api.models.users.createUser

import kotlin.random.Random

data class CreateUserRequest (
    var username: String,
    var password: String,
    var email: String
)

val defaultUser = CreateUserRequest(
    username = "user_${Random.nextInt(1000)}",
    password = "random",
    email = "${Random.nextInt(1000)}@autotest.com"
)