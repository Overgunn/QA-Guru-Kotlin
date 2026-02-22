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

    @Step("Проверка суммы в поп-ап окне")
    fun cartShouldHaveTotalSum(expectedText: String) {
        cartPopupTotalSum.shouldHave(text(expectedText))
    }

    @Step("Проверка наличия кнопки с текстом Checkout")
    fun popupShouldHaveCheckout(expectedSum: String) {
        cartPopupButton.shouldHave(text(expectedSum))
    }
}