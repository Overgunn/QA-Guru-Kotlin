package frontend

import frontend.helpers.BaseUiHelper
import frontend.components.popup.CreateAccountPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NegativeCreateAccountTest: BaseUiHelper() {

    @DisplayName("Parametrized create account validation negative test")
    @ParameterizedTest(name = "Username: {0}, Email{1}, Password: {2}, Error: {3}")
    @CsvSource(
        "'', '', '', 'Please enter username, email and password'",
        "'user', '', '', 'Please enter username, email and password'",
        "'user', '1@1.com', '', 'Please enter username, email and password'",
        "'q','q',q', 'Something went wrong. Please verify request.'"
    )
    fun createAccountValidation(username: String, email: String, password: String, expectedError: String) {

        MainPage().navigateHeader().clickLink("Join")

        CreateAccountPopup()
            .loginAs(username, email, password)
            .shouldHaveError(expectedError)
    }
}