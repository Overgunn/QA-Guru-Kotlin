/*
package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.CreateAccountPopup
import frontend.pages.JoinDialogPopup
import frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PositiveCreateAccountValidation: BaseUiHelper() {

    @DisplayName("Parametrized create account validation positive test")
    @ParameterizedTest(name = "Username: {0}, Email{1}, Password: {2}")
    @CsvSource(
        "'a','a','a'"
    )
    fun createAccountValidation(username: String, email: String, password: String) {

        MainPage().getHeader().clickLink("Join")

        val joinPopup = JoinDialogPopup()
        joinPopup.shouldBeVisible()

        val loginPopup = CreateAccountPopup()
        loginPopup.loginAs(username, email, password)
        loginPopup.checkIfUserIsLoggedIn()
    }
}*/
