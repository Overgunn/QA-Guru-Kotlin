package frontend

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import frontend.helpers.BaseUiHelper
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class TestOpenYoutube : BaseUiHelper() {

    @Test
    @DisplayName("Open YouTube main page")
    fun openYoutubeMainPage() {
        //Selenide.open("/")
        val title = Selenide.title()
        sleep(10_000)
        title shouldBe "YouTube"
    }
}