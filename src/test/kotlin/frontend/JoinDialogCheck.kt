package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.JoinDialogPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JoinDialogCheck: BaseUiHelper() {

    @Test
    @DisplayName("Check popup window after clicking Join header button")
    fun joinDialogPopup() {
        MainPage().getHeader().clickLink("Join")
        val joinPopup = JoinDialogPopup()
        joinPopup.shouldBeVisible()

        joinPopup.popupShouldHaveTitle("Create Account")
        joinPopup.signInPopupClick()
        joinPopup.popupShouldHaveTitle("Login")
    }
}