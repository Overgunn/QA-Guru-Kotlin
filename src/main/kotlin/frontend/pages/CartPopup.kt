package frontend.pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.element
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class CartPopup {
    private val cartPopup get() = element(".cart-popup")
    private val cartPopupTotalSum get() = element(byDataTestId("cart-total-price"))
    private val cartPopupButton get() = element(byDataTestId("cart-checkout"))

    @Step
    fun shouldBeVisible() {
        cartPopup.shouldBe(visible)
    }

    @Step("Check sum value in popup window")
    fun cartShouldHaveTotalSum(expectedText: String) {
        cartPopupTotalSum.shouldHave(text(expectedText))
    }

    @Step("Checkout button text check")
    fun popupShouldHaveCheckout(expectedSum: String) {
        cartPopupButton.shouldHave(text(expectedSum))
    }
}