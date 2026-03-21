package backend

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.models.users.createUser.defaultUser
import backend.controllers.Controllers
import io.kotest.matchers.collections.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GetAllUsersTest: Controllers() {

    @Test
    @DisplayName("Get requested user from all users")
    fun getUserFromAllUsers() {
        val user = users.createUser(defaultUser).getAsObject()
        val allUsers = users.getAllUsers().getAsObject()

        allUsers shouldContain user
    }
}
