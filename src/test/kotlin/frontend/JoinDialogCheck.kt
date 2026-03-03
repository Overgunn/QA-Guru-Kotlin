package frontend

import frontend.helpers.BaseUiHelper
import frontend.components.JoinDialogPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JoinDialogCheck: BaseUiHelper() {

    @Test
    @DisplayName("Check popup window after clicking 'Join' header button")
    fun joinDialogPopup() {
        MainPage()
            .getHeader()
            .clickLink("Join")

       JoinDialogPopup()
        .shouldBeVisible()
        .popupShouldHaveTitle("Create Account")
        .signInPopupClick()
    }
}