package frontend.components.popup

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.shadowCss
import com.codeborne.selenide.Selenide.element
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class LoginPopup {
    private val loginWindowTitle get() = element((".dialog > div:nth-child(2)"))
    private val emailInputLogin get() = element(shadowCss("input", "[data-test-id='login-email']"))
    private val passwordInputLogin get() = element(shadowCss("input", "[data-test-id='login-password']"))
    private val loginButtong get() = element(byDataTestId("login-submit"))
    private val errorMessageLogin get() = element(byDataTestId("login-error"))

    @Step("Checkout popup window title is 'Login'")
    fun getLoginWindowTitle (popupWindowTitle: String): LoginPopup {
        loginWindowTitle.shouldHave(Condition.text(popupWindowTitle))
        return this
    }

    @Step("Check credentials input for login window popup")
    fun loginWindowInput(email: String, password: String): LoginPopup {
        emailInputLogin.value = email
        passwordInputLogin.value = password
        loginButtong.click()
        return this
    }

    @Step("Error text check for invalid credentials input")
    fun shouldHaveError(expectedError: String): LoginPopup {
        errorMessageLogin.shouldHave(Condition.text(expectedError))
        return this
    }
}