package frontend.products

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.models.products.CreateProductRequest
import backend.controllers.Controllers
import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


@Feature("E2E testing")
@Story("Products")

class FavouriteProductsTest: BaseUiHelper() {

    private val controllers = Controllers()

    @Test
    @DisplayName("Check favorite products exists")
    fun favouriteProductsExists() {
        val body = CreateProductRequest(
                name = "Coffee Black",
                description = "Coffee black, no milk, no sugar",
                price = 1.5
        )
        val product = controllers.products.createProduct(product = body).getAsObject()

        val popularList = MainPage()
            .open()
            .getPopularProducts()

        popularList.size shouldBe 1
        popularList.first().name shouldBe product.name
    }
}