package frontend.components.popup

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.shadowCss
import com.codeborne.selenide.Selenide.element
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class CreateAccountPopup {

    private val usernameInput get() = element(byDataTestId("create-username")).find(shadowCss(".input"))
    private val emailInput get() = element(byDataTestId("create-email")).find(shadowCss(".input"))
    private val passwordInput get() = element(byDataTestId("create-password")).find(shadowCss(".input"))
    private val submitButton get() = element(byDataTestId("create-submit"))
    private val errorMessage get() = element(byDataTestId("create-error"))
    private val headerUserPic get() = element((".avatar"))

    @Step("Check user login with given credentials")
    fun loginAs(username: String, email: String, password: String): CreateAccountPopup {
        usernameInput.value = username
        emailInput.value = email
        passwordInput.value = password
        submitButton.click()
        return this
    }
    @Step("Error text check for invalid credentials input")
    fun getErrorMessage(expectedError: String): String {
        errorMessage.shouldBe(visible)
        return errorMessage.text
    }

    @Step("Check if user is logged in")
    fun checkIfUserIsLoggedIn(): CreateAccountPopup {
        headerUserPic.shouldBe(visible)
        return this
    }
}