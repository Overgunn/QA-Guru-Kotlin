package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.CartPopup
import frontend.pages.MainPage
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Cart Popup")
@Story("FrontEnd: Cart popup window basic check")
@Tags(Tag("cart-popup"),Tag("frontend"))

class CartPopupCheck: BaseUiHelper() {

    @Test
    @DisplayName("Check popup window after clicking Cart header link")
    fun cartPopupClick() {
        MainPage().getHeader().clickLink("Cart")
        val cartPopup = CartPopup()
        cartPopup.shouldBeVisible()

        cartPopup.cartShouldHaveTotalSum("$0.00")
        cartPopup.popupShouldHaveCheckout("Checkout")
    }
}