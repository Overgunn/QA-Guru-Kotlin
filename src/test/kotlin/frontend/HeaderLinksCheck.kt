package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Check header links")
@Story("FrontEnd: basic header links clicking")
@Tags(Tag("header-links"),Tag("frontend"))

class HeaderLinksCheck: BaseUiHelper() {

    @Test
    @DisplayName("Clicking all header links")
    fun allHeaderLinksCheck() {
        MainPage().getHeader().clickAllLinks()
    }
}