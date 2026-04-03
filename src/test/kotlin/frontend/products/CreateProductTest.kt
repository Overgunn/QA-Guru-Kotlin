package frontend.products

import backend.api.extension.Extensions.Companion.getAsObject
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

        productsHelper.createTeaProduct(4)

        val userToken = authHelper.getNewToken()
        productsHelper.addProduct(name = "Coffee", count = 5, token = userToken)


        val backendCount = controllers.products.getProducts().getAsObject()
            .filter { it.name.contains("Coffee", ignoreCase = true) }.size

        val frontendCount = ProductsPage()
            .open()
            .getProductItems()
            .filter { it.name.contains("Coffee", ignoreCase = true) }.size

        backendCount shouldBeEqual frontendCount
    }
}