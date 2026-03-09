package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import frontend.pages.ProductsPage
import io.kotest.matchers.collections.shouldContainAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProductsCompareTest: BaseUiHelper() {

    @Test
    @DisplayName("Comparing popular items from main page with items on product page")
    fun `comparing popular items from main page with items on product page`(){
            val mainPageItems = MainPage()
                .open()
                .getPopularProducts()
                .map{ it.name }

        MainPage().navigateHeader().clickLink("Products")

       val productPageItems = ProductsPage().getProductsItems().map{ it.name }
        mainPageItems shouldContainAll productPageItems
    }
}