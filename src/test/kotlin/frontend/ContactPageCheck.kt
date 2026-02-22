package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.ContactPage
import frontend.pages.MainPage
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Contact page")
@Story("FrontEnd: Contact page basic check")
@Tags(Tag("Contact-page"),Tag("frontend"))

class ContactPageCheck: BaseUiHelper() {

    @Test
    @DisplayName("Header navigation check: go to Contact page and check 1st line text content")
    fun contactPageCheck() {
        MainPage().getHeader().clickLink("Contact")

        val contactPage = ContactPage()
        contactPage.shouldHaveTitle("Testing Playground Frontend")
    }
}