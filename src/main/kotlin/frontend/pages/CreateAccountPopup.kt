package frontend.pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.selector.ByShadowCss
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class CreateAccountPopup {

    private val usernameInput get() = element(ByShadowCss.cssSelector("input", "[data-test-id='create-username']"))
    private val emailInput get() = element(ByShadowCss.cssSelector("input","[data-test-id='create-email']"))
    private val passwordInput get() = element(ByShadowCss.cssSelector("input","[data-test-id='create-password']"))
    private val submitButton get() = element(byDataTestId("create-submit"))
    private val errorMessage get() = element(byDataTestId("create-error"))

    @Step
    fun loginAs(username: String, email: String, password: String) {
        usernameInput.setValue(username)
        emailInput.setValue(email)
        passwordInput.setValue(password)
        submitButton.click()
    }
    @Step
    fun shouldHaveError(expectedError: String) {
        errorMessage.shouldHave(text(expectedError))
    }
}