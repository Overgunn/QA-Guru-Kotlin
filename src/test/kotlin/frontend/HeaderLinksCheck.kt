package frontend

import frontend.helpers.BaseUiHelper
import io.kotest.matchers.nulls.shouldNotBeNull
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Feature("Check header links")
@Story("FrontEnd: basic header links checking")
@Tags(Tag("header-links"),Tag("frontend"))

class HeaderLinksCheck: BaseUiHelper() {

    @DisplayName("Checking all header links")
    @ParameterizedTest
    @ValueSource(strings = ["Brew & Bean","Products","Orders","Cart","Contact"])
    fun allHeaderLinksCheck(headerLink: String) {
        headerLink.shouldNotBeNull()
    }
}