package frontend

import frontend.helpers.BaseUiHelper
import frontend.components.JoinDialogPopup
import frontend.components.LoginPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LoginDialogCheck: BaseUiHelper() {

    @Test
    @DisplayName("Check after clicking 'Your account' link  in 'Join' popup window")
    fun loginDialogPopup() {
        MainPage()
            .getHeader()
            .clickLink("Join")

        JoinDialogPopup()
            .signInPopupClick()

        LoginPopup()
            .loginWindowVisible()
            .getLoginWindowTitle("Login")
            .loginWindowEmailPh()
            .loginWindowPasswordPh()
    }
}