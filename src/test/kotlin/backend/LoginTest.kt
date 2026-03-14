package backend

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.extension.Extensions.Companion.getErrorAsObject
import backend.controllers.Controllers
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import org.example.kotlin.backend.api.models.ErrorResponse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LoginTest: Controllers() {
    @Test
    @DisplayName("Login with email and password")
    fun testLoginWithValidCredentials() {
        val response = auth.login("1admin", "admin").getAsObject()

        response.refreshToken.length shouldBeGreaterThan 10
    }

    @Test
    @DisplayName("Login with invalid credentials should return error")
    fun testLoginWithInvalidCredentials() {
        val response = auth.login("invalid", "credentials").getErrorAsObject<ErrorResponse>()

        response.code shouldBe 400
        response.reason shouldBe "Invalid email or password"
    }
}