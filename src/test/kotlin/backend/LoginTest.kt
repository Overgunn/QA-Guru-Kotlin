package backend

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.extension.Extensions.Companion.getErrorAsObject
import backend.controllers.Controllers
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import backend.api.models.ErrorResponse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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
        val response = auth.login("random", "credentials").getErrorAsObject<ErrorResponse>()

        response.code shouldBe 400
        response.reason shouldBe "Invalid email or password"
    }
}