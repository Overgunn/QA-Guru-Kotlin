package frontend

import frontend.helpers.BaseUiHelper
import frontend.components.popup.JoinDialogPopup
import frontend.pages.MainPage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JoinDialogTest: BaseUiHelper() {

    @Test
    @DisplayName("Check popup window after clicking 'Join' header button")
    fun joinDialogPopup() {
        MainPage()
            .navigateHeader()
            .clickLink("Join")

        JoinDialogPopup()
            .getTitle() shouldBe "Create Account"
    }
}