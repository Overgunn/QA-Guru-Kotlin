package frontend.cart

import frontend.components.list.CartItems
import frontend.components.list.ProductItem
import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import io.kotest.matchers.equality.shouldBeEqualToDifferentTypeIgnoringFields
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CartTest: BaseUiHelper() {

    @Test
    @DisplayName("Check items in cart")
    fun addCartItemsTest(){
        val lastPopularItem = MainPage()
            .open()
            .getPopularProducts()
            .last()

        lastPopularItem.btnIncrement.click()

MainPage().navigateHeader().clickLink("Cart")
        val lastCartItem = CartItems().getItems().last { it.name == lastPopularItem.name }

        lastPopularItem.apply {quantity = 1}
            .shouldBeEqualToDifferentTypeIgnoringFields(
            lastCartItem,
                ProductItem::description,
                ProductItem::btnIncrement,
                ProductItem::btnDecrement,
                ProductItem::image
        )
    }
}