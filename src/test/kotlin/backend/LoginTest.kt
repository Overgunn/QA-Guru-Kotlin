package backend

import backend.api.extension.Extensions.Companion.getAsObject
import backend.controllers.Controllers
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import backend.api.models.ErrorResponse
import backend.api.models.auth.AuthErrorResponses
import com.google.gson.Gson
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LoginTest: Controllers() {
    @Test
    @DisplayName("Positive check: Login with email and password")
    fun testLoginWithValidCredentials() {
        val response = auth.login("admin", "admin").getAsObject()

        response.refreshToken.length shouldBeGreaterThan 10
        response.accessToken.length shouldBeGreaterThan 10
    }

    @Test
    @DisplayName("Negative check: Login with invalid credentials should return error")
    fun testLoginWithInvalidCredentials() {
        val response = auth.login("random", "credentials")

        val error = Gson().fromJson(
            response.errorBody()?.string(),
            ErrorResponse::class.java
        )
        response.code() shouldBe 400
        error shouldNotBe null
        error?.code shouldBe AuthErrorResponses.invalidCredentials.code
        error?.reason shouldBe AuthErrorResponses.invalidCredentials.reason
    }

    @ParameterizedTest(name = "Email: {0}, Password {1}")
    @DisplayName("Negative check: Log in with empty credentials should return error")
    @CsvSource(
        "'', ''",
        "'user', ''",
        "'', '1@1.com'")
    fun testLoginWithEmptyCredentials(email: String, password: String) {
        val response = auth
            .login(email, password)

        val error = Gson().fromJson(
            response.errorBody()?.string(),
            ErrorResponse::class.java
        )
        response.code() shouldBe 400
        error shouldNotBe null
        error?.code shouldBe AuthErrorResponses.invalidCredentials.code
        error?.reason shouldBe AuthErrorResponses.invalidCredentials.reason
    }
}