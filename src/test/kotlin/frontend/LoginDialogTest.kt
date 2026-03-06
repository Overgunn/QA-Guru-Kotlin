package frontend

import frontend.helpers.BaseUiHelper
import frontend.components.popup.JoinDialogPopup
import frontend.components.popup.LoginPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LoginDialogTest: BaseUiHelper() {

    @Test
    @DisplayName("Check after clicking 'Your account' link  in 'Join' popup window")
    fun loginDialogPopup() {
        MainPage()
            .getHeader()
            .clickLink("Join")

        JoinDialogPopup()
            .signInPopupClick()

        LoginPopup()
            .getLoginWindowTitle("Login")
    }
}