package frontend.components

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.selector.ByShadowCss
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class LoginPopup {
    private val loginWindowIsVisible get() = element(".dialog")
    private val loginWindowTitle get() = element(byDataTestId(".dialog > div:nth-child(2)"))
    private val loginWindowEmailPh get() = element("[placeholder='Email']")
    private val loginWindowPasswordPh get() = element("[placeholder='Password']")
    private val emailInputLogin get() = element(ByShadowCss.cssSelector("input", "[data-test-id='login-email']"))
    private val passwordInputLogin get() = element(ByShadowCss.cssSelector("input", "[data-test-id='login-password']"))
    private val loginButtong get() = element(byDataTestId("login-submit"))
    private val errorMessageLogin get() = element(byDataTestId("login-error"))
    private val headerUserPic get() = element((".avatar"))

    @Step("Popup window is visible")
    fun loginWindowVisible(): LoginPopup {
        loginWindowIsVisible.shouldBe(Condition.visible)
        return this
    }

    @Step("Checkout popup window title is 'Login'")
    fun getLoginWindowTitle (popupWindowTitle: String): LoginPopup {
        loginWindowTitle.shouldHave(Condition.text(popupWindowTitle))
        return this
    }

    @Step("Check if placeholder 'Order ID'-text is present in input field")
    fun loginWindowEmailPh(): LoginPopup {
        loginWindowEmailPh.shouldHave(Condition.attribute("placeholder", "Email"))
        return this
    }

    @Step("Check if placeholder 'Order ID'-text is present in input field")
    fun loginWindowPasswordPh(): LoginPopup {
        loginWindowPasswordPh.shouldHave(Condition.attribute("placeholder", "Password"))
        return this
    }

    @Step("Check credentials input for login window popup")
    fun loginWindowInput(email: String, password: String): LoginPopup {
        emailInputLogin.setValue(email)
        passwordInputLogin.setValue(password)
        loginButtong.click()
        return this
    }

    @Step("Error text check for invalid credentials input")
    fun shouldHaveError(expectedError: String): LoginPopup {
        errorMessageLogin.shouldHave(Condition.text(expectedError))
        return this
    }

    @Step("Check if user is logged in")
    fun checkIfUserIsLoggedIn(): LoginPopup {
        headerUserPic.shouldBe(Condition.visible)
        return this
    }
}