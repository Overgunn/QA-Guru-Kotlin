package frontend.products

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.models.products.CreateProductRequest
import frontend.helpers.BaseUiHelper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import backend.controllers.Controllers
import backend.helpers.AuthorizationHelper
import frontend.pages.MainPage
import io.kotest.matchers.equals.shouldBeEqual


class CreateProductTest: BaseUiHelper() {
    private val controllers = Controllers()
    private val authHelper = AuthorizationHelper()


    @Test
    @DisplayName("Create and check created products")
    fun createAndCheckProducts() {

        val productsCheck = controllers.products.getProducts()


        var checkCoffeeProducts = if (productsCheck.isSuccessful) {
            productsCheck.getAsObject().filter { it.name.contains("Coffee", ignoreCase = true) }
        } else {
            emptyList()
        }

        if (checkCoffeeProducts.isEmpty()) {
            repeat(5) { i ->
                controllers.products.createProduct(
                    token = authHelper.getAdminToken(),
                    product = CreateProductRequest(
                        name = "COFFEE #$i",
                        description = "Description for coffee #$i",
                        price = i.toDouble()
                    )
                )
            }
            checkCoffeeProducts = controllers.products.getProducts().getAsObject()
                .filter { it.name.contains("COFFEE", ignoreCase = true) }
        }
        val backendCount = checkCoffeeProducts.size

        val frontendCount = MainPage()
            .open()
            .getPopularProducts().size

        backendCount shouldBeEqual frontendCount
    }
}