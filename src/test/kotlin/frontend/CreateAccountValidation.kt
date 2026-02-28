package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.CreateAccountPopup
import frontend.pages.JoinDialogPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CreateAccountValidation: BaseUiHelper() {

    @DisplayName("Parametrized create account validation test")
    @ParameterizedTest(name = "Username: {0}, Email{1}, Password: {2}, Error: {3}")
    @CsvSource(
        "'', '', '', 'Please enter username, email and password'",
        "'user', '', '', 'Please enter username, email and password'",
        "'user', '1@1.com', '', 'Please enter username, email and password'",
        //"'wrongUser', 'qqq', '12345', 'Something went wrong. Please verify request.'"
    )
    fun createAccountValidation(username: String, email: String, password: String, expectedError: String) {

        MainPage().getHeader().clickLink("Join")

        val joinPopup = JoinDialogPopup()
        joinPopup.shouldBeVisible()

        val loginPopup = CreateAccountPopup()
        loginPopup.loginAs(username, email, password)
        loginPopup.shouldHaveError(expectedError)
    }
}