package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import io.kotest.matchers.collections.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class HeaderLinksCheck: BaseUiHelper() {

    @ParameterizedTest
    @ValueSource(strings = ["Brew & Bean", "Products", "Orders", "Cart", "Contact"])
    @DisplayName("Header contains exactly the expected links")
    fun allHeaderLinksCheck(expectedLinks: String) {
        val actualLinks = MainPage()
            .getHeader()
            .getLinkNames()

        actualLinks shouldContain expectedLinks
    }
}