package frontend.components.popup

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class CartPopup {
    private val cartPopupTotalSum get() = element(byDataTestId("cart-total-price"))
    private val cartCheckoutButton get() = element(byDataTestId("cart-checkout"))

    @Step("Check sum value in popup window")
    fun cartShouldHaveTotalSum(expectedText: String): CartPopup {
        cartPopupTotalSum.shouldHave(Condition.text(expectedText))
        return this
    }

    @Step("Checkout button text check")
    fun popupCheckoutButton(expectedSum: String): CartPopup {
        cartCheckoutButton.shouldHave(Condition.text(expectedSum))
        return this
    }

    @Step("Get cart total price")
    fun getTotalPrice(): Float {
        return cartPopupTotalSum.text.filter {it.isDigit()}.toFloat() / 100f
    }
}