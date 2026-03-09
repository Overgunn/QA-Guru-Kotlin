package frontend

import frontend.components.list.CartItems
import frontend.components.list.PopularItem
import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import io.kotest.matchers.equality.shouldBeEqualToDifferentTypeIgnoringFields
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CartTest: BaseUiHelper() {

    @Test
    @DisplayName("Check items in cart")
    fun `adding items in cart from main page`(){
        val lastPopularItem = MainPage()
            .getPopularProducts()
            .last()

        lastPopularItem.btnIncrement.click()

MainPage().navigateHeader().clickLink("Cart")
        val lastCartItem = CartItems().getItems().last { it.name == lastPopularItem.name }

        lastPopularItem.apply {quantity = 1}
            .shouldBeEqualToDifferentTypeIgnoringFields(
            lastCartItem,
            PopularItem::description,
            PopularItem::btnIncrement,
            PopularItem::btnDecrement,
            PopularItem::image
        )
    }
}