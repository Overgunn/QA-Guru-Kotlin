package frontend.components.popup

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class JoinDialogPopup {
    private val joinDialogPopupTitle get() = element(byDataTestId("create-title"))
    private val joinDialogPopupCreate get() = element(byDataTestId("create-login"))

    @Step("Checkout popup window title is 'Create Account'")
    fun popupShouldHaveTitle(popupWindowTitle: String): JoinDialogPopup {
        joinDialogPopupTitle.shouldHave(Condition.text(popupWindowTitle))
        return this
    }
    @Step("Click 'Log in to your account' link")
    fun signInPopupClick(): JoinDialogPopup {
        joinDialogPopupCreate.click()
        return this
    }
}