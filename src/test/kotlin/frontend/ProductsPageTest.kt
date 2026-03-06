package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import frontend.pages.ProductsPage
import io.kotest.matchers.collections.shouldHaveSize
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Products page")
@Story("FrontEnd: Products page basic check")
@Tags(Tag("Products-page"),Tag("frontend"))

class ProductsPageTest: BaseUiHelper() {

    @Test
    @DisplayName("Header navigation check: go to Products page and check number of available products")
    fun productPageCheck() {
        MainPage().getHeader().clickLink("Products")

        val products = ProductsPage().getProducts()
        products shouldHaveSize 4
    }
}