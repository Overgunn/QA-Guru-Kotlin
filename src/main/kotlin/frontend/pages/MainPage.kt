package frontend.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import frontend.components.HeaderComponent
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class MainPage {
    private val txtTitle get() = element(byDataTestId("main-image-text"))

    @Step("Открыть главную страницу")
    fun open() {
        Selenide.open("/")
    }

    @Step("Получить название главной страницы")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Перейти к компоненту Header")
    fun getHeader(): HeaderComponent {
        return HeaderComponent()
    }
}