package frontend.pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.elements
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import io.qameta.allure.Step

class ProductsPage {
    private val itemList get() = elements(byDataTestGroup("product-card"))

    @Step("Получить список продуктов")
    fun getProducts(): ElementsCollection {
        return this.itemList
    }
}