package frontend.products

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.extension.Extensions.Companion.toBearer
import backend.api.models.products.CreateProductRequest
import backend.api.models.users.createUser.defaultUser
import frontend.helpers.BaseUiHelper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import backend.controllers.Controllers
import backend.helpers.ProductHelper
import frontend.pages.MainPage
import io.kotest.matchers.equals.shouldBeEqual


class CreateProductTest: BaseUiHelper() {
    private val controllers = Controllers()
    val productsHelper = ProductHelper()

    @Test
    @DisplayName("Create and check created products")
    fun createAndCheckProducts() {

        val listOfTea = productsHelper.createTeaProduct(5)
        //val listOfCoffee = productsHelper.createCoffeeProduct(4)

        val createTestUser = defaultUser()
        controllers.users.createUser(createTestUser)
        val testUserToken = controllers.auth.login(
            email = createTestUser.email,
            password = createTestUser.password
        ).getAsObject().accessToken.toBearer()

        controllers.products.getProducts().getAsObject()
            .firstOrNull { it.name.contains("Coffee", ignoreCase = true) }
            ?: run {
                repeat(5) { i ->
                    controllers.products.createProduct(
                        token = testUserToken,
                        product = CreateProductRequest(
                            name = "COFFEE #$i",
                            description = "Description for coffee #$i",
                            price = i.toDouble()
                        )
                    )
                }
            }

        val backendCount = controllers.products.getProducts().getAsObject()
            .filter { it.name.contains("COFFEE", ignoreCase = true) }.size

        val frontendCount = MainPage()
            .open()
            .getPopularProducts()
            .filter { it.name.contains("Coffee", ignoreCase = true) }.size

        backendCount shouldBeEqual frontendCount
    }
}