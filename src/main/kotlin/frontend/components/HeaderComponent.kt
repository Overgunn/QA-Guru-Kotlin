package frontend.components

import com.codeborne.selenide.Selenide.elements
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import io.qameta.allure.Step

class HeaderComponent {
    val linksHeader get() = elements(byDataTestGroup("nav-link"))

    @Step("Нажать на ссылку в шапке {name}")
    fun clickLink(name: String): HeaderComponent {
        linksHeader.first { it.text == name }.click()
        return this
    }

    @Step("Пройти по всем ссылкам в хедере")
    fun clickAllLinks(): HeaderComponent {
        val linkNames = linksHeader.map { it.text }
        linkNames.forEach { clickLink(it) }
        return this
    }
}