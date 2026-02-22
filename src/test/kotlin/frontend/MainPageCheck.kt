package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Main page")
@Story("FrontEnd: Main page basic check")
@Tags(Tag("Main-page"),Tag("frontend"))

class MainPageCheck : BaseUiHelper() {

    @Test
    @DisplayName("Проверка названия на главной странице")
    fun mainPageCheck() {
        val title = MainPage()
            .getTitle()
        title shouldBe "Welcome to Brew & Bean"
    }
}