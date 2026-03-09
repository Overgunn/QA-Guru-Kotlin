package frontend.components.list

import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import frontend.helpers.Wrappers.Companion.byDataTestGroup
import frontend.helpers.Extensions.Companion.toMoney

class PopularItems {
    private val popularProducts = elements(byDataTestGroup("product-card"))

    fun getItems(): List<PopularItem> {
        return popularProducts
            .map {
                PopularItem(
                image = it.find(byDataTestGroup("product-card-image")),
                name = it.find(byDataTestGroup("product-card-name")).text,
                description = it.find(byDataTestGroup("product-card-description")).text,
                price = it.find(byDataTestGroup("product-card-price")).text.toMoney(),
                btnIncrement = it.find(byDataTestGroup("product-card-increment")),
                btnDecrement = it.find(byDataTestGroup("product-card-decrement")),
                quantity = it.find(byDataTestGroup("product-card-qty")).text.toInt()
            ) }
    }
}

data class PopularItem(
    val image: SelenideElement,
    val name: String,
    val description: String,
    val price: Double,
    val btnIncrement: SelenideElement,
    val btnDecrement: SelenideElement,
    var quantity: Int
)