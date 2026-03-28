package frontend.login

import frontend.helpers.BaseUiHelper
import frontend.components.popup.JoinDialogPopup
import frontend.components.popup.LoginPopup
import frontend.pages.MainPage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LoginDialogTest: BaseUiHelper() {

    @Test
    @DisplayName("Check after clicking 'Your account' link  in 'Join' popup window")
    fun loginDialogPopup() {
        MainPage()
            .navigateHeader()
            .clickLink("Join")

        JoinDialogPopup()
            .signInPopupClick()

        LoginPopup()
            .getLoginWindowTitle() shouldBe "Login"
    }
}