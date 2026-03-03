package frontend

import frontend.helpers.BaseUiHelper
import frontend.components.JoinDialogPopup
import frontend.components.LoginPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NegativeLoginValidation: BaseUiHelper() {

    @DisplayName("Parametrized login validation negative test")
    @ParameterizedTest(name = "Email {0}, Password: {1}, Error: {2}")
    @CsvSource(
        "'', '', 'Please enter email and password'",
        "'1@1.com', '', 'Please enter email and password'",
        "'1@1.com', '111', 'Invalid email or password'"
    )
    fun loginValidation(email: String, password: String, expectedError: String) {

        MainPage()
            .getHeader()
            .clickLink("Join")

        JoinDialogPopup()
            .signInPopupClick()

        LoginPopup()
            .loginWindowVisible()
            .loginWindowInput(email, password)
            .shouldHaveError(expectedError)
    }
}