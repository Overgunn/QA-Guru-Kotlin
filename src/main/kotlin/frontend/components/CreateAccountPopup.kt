package frontend.components

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.selector.ByShadowCss
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class CreateAccountPopup {
    private val usernameInput get() = element(ByShadowCss.cssSelector("input", "[data-test-id='create-username']"))
    private val emailInput get() = element(ByShadowCss.cssSelector("input", "[data-test-id='create-email']"))
    private val passwordInput get() = element(ByShadowCss.cssSelector("input", "[data-test-id='create-password']"))
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
    fun shouldHaveError(expectedError: String): CreateAccountPopup {
        errorMessage.shouldHave(Condition.text(expectedError))
        return this
    }

    @Step("Check if user is logged in")
    fun checkIfUserIsLoggedIn(): CreateAccountPopup {
        headerUserPic.shouldBe(Condition.visible)
        return this
    }
}