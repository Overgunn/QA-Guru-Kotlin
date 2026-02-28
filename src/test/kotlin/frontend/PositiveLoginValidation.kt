package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.JoinDialogPopup
import frontend.pages.LoginPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PositiveLoginValidation: BaseUiHelper() {

    @DisplayName("Parametrized login validation positive test")
    @ParameterizedTest(name = "Email{0}, Password: {1}")
    @CsvSource(
        "'q', 'q'"
    )
    fun loginValidation(email: String, password: String) {

        MainPage().getHeader().clickLink("Join")
        val joinPopup = JoinDialogPopup()
        joinPopup.shouldBeVisible()
        joinPopup.signInPopupClick()

        val loginPopupForm = LoginPopup()
        loginPopupForm.loginWindowVisible()
        loginPopupForm.loginWindowInput(email, password)
        loginPopupForm.checkIfUserIsLoggedIn()
    }
}