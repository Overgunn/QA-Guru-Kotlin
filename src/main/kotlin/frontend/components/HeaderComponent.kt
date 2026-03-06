package frontend.components

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import frontend.helpers.Wrappers.Companion.shouldBeVisible
import io.qameta.allure.Step

class HeaderComponent {
    private val linksHeader get() = elements(byDataTestGroup("nav-link"))
    private val headerUserPic get() = element((".avatar"))

    @Step("Clicks header {name} link")
    fun clickLink(name: String): HeaderComponent {
        linksHeader.first { it.text == name }.click()
        return this
    }

    @Step("Get all header link names")
    fun getLinkNames(): List<String> {
        return linksHeader.map { it.text }
    }

    @Step("Checks if avatar is present on the header after successful logging in")
    fun checkUserPic(): Boolean {
        return headerUserPic.shouldBeVisible()
    }
}