package backend

import backend.api.models.ErrorResponse
import backend.api.models.createUser.CreateUserErrors
import backend.controllers.Controllers
import com.google.gson.Gson
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldStartWith
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.util.UUID
import kotlin.jvm.java

class CreateUserTest: Controllers() {
    @Test
    @DisplayName("Positive check: create user with valid credentials")
    fun testUsersCreate() {
        val username = "user_${UUID.randomUUID()}"
        val email = "$username@test.com"
        val password = "Password123!"
        val response = createUser
            .createNewUser(username, email, password)
            .execute()

        response.code() shouldBe 200
        val body = response.body()!!
        body.phoneNumber.isEmpty() shouldBe true
        body.username shouldStartWith "user_"
        body.email shouldStartWith "user_"
    }

    @Test
    @DisplayName("Negative check: creating user with invalid credentials should return error")
    fun testUsersCreateWithInvalidCredentials() {
        val username = "1!"
        val email = "1@"
        val password = "1-"
        val response = createUser
            .createNewUser(username, email, password)
            .execute()

        val error = Gson().fromJson(
            response.errorBody()?.string(),
            ErrorResponse::class.java
        )
        response.code() shouldBe 400
        error shouldNotBe null
        error?.code shouldBe CreateUserErrors.invalidCredentials.code
        error?.reason shouldBe CreateUserErrors.invalidCredentials.reason
    }

    @Test
    @DisplayName("Negative check: creating user with already existing credentials should return error")
    fun testUsersCreateAlreadyExistingCredentials() {
        val username = "admin"
        val email = "admin"
        val password = "admin"
        val response = createUser
            .createNewUser(username, email, password)
            .execute()

        val error = Gson().fromJson(
            response.errorBody()?.string(),
            ErrorResponse::class.java
        )
        response.code() shouldBe 400
        error shouldNotBe null
        error?.code shouldBe CreateUserErrors.duplicateCredentials.code
        error?.reason shouldBe CreateUserErrors.duplicateCredentials.reason
    }


    @ParameterizedTest(name = "Username: {0}, Email {1}, Password: {2}")
    @DisplayName("Negative check: creating user with empty credentials should return error")
    @CsvSource(
        "'', '', ''",
        "'user', '', ''",
        "'user', '1@1.com', ''")
    fun testUsersCreateEmptyCredentials(username: String, email: String, password: String) {
        val response = createUser
            .createNewUser(username, email, password)
            .execute()

        val error = Gson().fromJson(
            response.errorBody()?.string(),
            ErrorResponse::class.java
        )

        response.code() shouldBe 400
        error shouldNotBe null
        error?.code shouldBe CreateUserErrors.emptyCredentials.code
        error?.reason shouldBe CreateUserErrors.emptyCredentials.reason
    }
}

