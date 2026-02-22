package frontend.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import frontend.components.HeaderComponent
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class MainPage {
    private val txtTitle get() = element(byDataTestId("main-image-text"))

    @Step("Open main page")
    fun open() {
        Selenide.open("/")
    }

    @Step("Get main page name {string}")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Go to header component")
    fun getHeader(): HeaderComponent {
        return HeaderComponent()
    }
}