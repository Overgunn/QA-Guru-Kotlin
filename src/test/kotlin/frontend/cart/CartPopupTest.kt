package frontend.cart

import frontend.helpers.BaseUiHelper
import frontend.components.popup.CartPopup
import frontend.pages.MainPage
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Cart Popup")
@Story("FrontEnd: Cart popup window basic check")
@Tags(Tag("cart-popup"),Tag("frontend"))

class CartPopupTest: BaseUiHelper() {

    @Test
    @DisplayName("Check popup window after clicking Cart header link")
    fun cartPopupClick() {
        MainPage().navigateHeader().clickLink("Cart")

        CartPopup()
            .cartButtonText() shouldBe "Checkout"
    }
}