package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import frontend.pages.OrdersPage
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Orders page")
@Story("FrontEnd: Orders page basic check")
@Tags(Tag("Orders-page"),Tag("frontend"))

class OrdersPageTest: BaseUiHelper() {

    @Test
    @DisplayName("Header navigation check: go to Orders page")
    fun ordersCheck() {
        MainPage().getHeader().clickLink("Orders")

        val ordersPage = OrdersPage()
        ordersPage.shouldHaveCorrectPlaceholder()
    }
}