package frontend.products

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.models.products.CreateProductRequest
import frontend.helpers.BaseUiHelper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import backend.controllers.Controllers
import backend.helpers.AuthorizationHelper
import backend.helpers.ProductHelper
import frontend.pages.ProductsPage
import io.kotest.matchers.equals.shouldBeEqual


class CreateProductTest: BaseUiHelper() {
    private val controllers = Controllers()
    val productsHelper = ProductHelper()
    val authHelper = AuthorizationHelper()

    @Test
    @DisplayName("Create and check created products")
    fun createAndCheckProducts() {

        val listOfTea = productsHelper.createTeaProduct(4)

       val userToken = authHelper.getNewToken()

        controllers.products.getProducts().getAsObject()
            .firstOrNull { it.name.contains("Coffee", ignoreCase = true) }
            ?: run {
                repeat(5) { i ->
                    controllers.products.createProduct(
                        token = userToken,
                        product = CreateProductRequest(
                            name = "Coffee #$i",
                            description = "Description for coffee #$i",
                            price = i.toDouble()
                        )
                    )
                }
            }

        val backendCount = controllers.products.getProducts().getAsObject()
            .filter { it.name.contains("Coffee", ignoreCase = true) }.size

        val frontendCount = ProductsPage()
            .open()
            .getProductItems()
            .filter { it.name.contains("Coffee", ignoreCase = true) }.size

        backendCount shouldBeEqual frontendCount
    }
}