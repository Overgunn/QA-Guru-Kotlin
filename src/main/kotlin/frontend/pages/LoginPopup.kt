package frontend.pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.selector.ByShadowCss
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class LoginPopup {
    private val loginWindowIsVisible get() = element(".dialog")
    private val loginWindowTitle get() = element((".dialog > div:nth-child(2)"))
    private val emailInputLogin get() = element(ByShadowCss.cssSelector("input","[data-test-id='login-email']"))
    private val passwordInputLogin get() = element(ByShadowCss.cssSelector("input","[data-test-id='login-password']"))
    private val loginButtong get() = element(byDataTestId("login-submit"))
    private val errorMessageLogin get() = element(byDataTestId("login-error"))
    val headerUserPic get() = element((".avatar"))

    @Step("Popup window is visible")
    fun loginWindowVisible() {
        loginWindowIsVisible.shouldBe(visible)
    }

    @Step("Checkout popup window title is 'Login'")
    fun getLoginWindowTitle (popupWindowTitle: String) {
        loginWindowTitle.shouldHave(text(popupWindowTitle))
    }

    @Step
    fun loginWindowInput(email: String, password: String) {
        emailInputLogin.setValue(email)
        passwordInputLogin.setValue(password)
        loginButtong.click()
    }
    @Step
    fun shouldHaveError(expectedError: String) {
        errorMessageLogin.shouldHave(text(expectedError))
    }

    @Step("Check if user is logged in")
    fun checkIfUserIsLoggedIn() {
        headerUserPic.shouldBe(visible)
    }
}