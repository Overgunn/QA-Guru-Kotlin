package frontend.pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step

class ContactPage {
    private val contactCard: SelenideElement
        get() = element(".contact-card")

    @Step("Проверка 1ой строки в карточке контакта")
    fun shouldHaveTitle(expectedText: String) {
        contactCard.shouldHave(text(expectedText))
    }
}