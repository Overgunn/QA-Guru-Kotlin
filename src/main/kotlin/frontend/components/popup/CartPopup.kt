package frontend.components.popup

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class CartPopup {
    private val cartPopupTotalSum get() = element(byDataTestId("cart-total-price"))
    private val cartCheckoutButton get() = element(byDataTestId("cart-checkout"))

    @Step("Check sum value in popup window")
    fun cartShouldHaveTotalSum(): String {
        cartPopupTotalSum.shouldBe(visible)
        return cartPopupTotalSum.text
    }

    @Step("Checkout button text check")
    fun cartButtonText(): String {
        cartCheckoutButton.shouldBe(visible)
        return cartCheckoutButton.text
    }

    @Step("Get cart total price")
    fun getTotalPrice(): Float {
        return cartPopupTotalSum.text.filter {it.isDigit()}.toFloat() / 100f
    }
}