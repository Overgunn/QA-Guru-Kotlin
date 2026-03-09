package frontend.pages

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step

class ContactPage {
    private val contactCard: SelenideElement get() = element(".contact-card")

    @Step("Check 1st text line in contact card")
    fun getContactTitle(): String {
        return contactCard.text
    }
}