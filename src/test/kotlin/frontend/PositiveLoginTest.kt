package frontend

import frontend.helpers.BaseUiHelper
import frontend.components.popup.JoinDialogPopup
import frontend.components.popup.LoginPopup
import frontend.pages.MainPage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PositiveLoginTest: BaseUiHelper() {

    @DisplayName("Parametrized login validation positive test")
    @ParameterizedTest(name = "Email {0}, Password: {1}")
    @CsvSource(
        "'q', 'q'"
    )
    fun loginValidation(email: String, password: String) {

        MainPage()
            .navigateHeader()
            .clickLink("Join")

        JoinDialogPopup()
            .signInPopupClick()

        LoginPopup()
            .loginWindowInput(email, password)

        val isVisible = MainPage().navigateHeader().checkUserPic()
        isVisible shouldBe true
    }
}