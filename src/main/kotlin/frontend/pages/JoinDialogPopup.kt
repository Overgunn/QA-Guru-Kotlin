package frontend.pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class JoinDialogPopup {
    private val joinDialogPopup get() = element(".dialog")
    private val joinDialogPopupTitle get() = element((".dialog > div:nth-child(2)"))
    private val joinDialogPopupCreate get() = element(byDataTestId("create-login"))

    @Step("Popup window is visible")
    fun shouldBeVisible() {
        joinDialogPopup.shouldBe(visible)
    }
    @Step("Checkout popup window title is 'Create Account'")
    fun popupShouldHaveTitle(popupWindowTitle: String) {
        joinDialogPopupTitle.shouldHave(text(popupWindowTitle))
    }
    @Step("Click 'Log in to your account' link")
    fun signInPopupClick() {
        joinDialogPopupCreate.click()
    }
}