package frontend.products

import backend.helpers.ProductHelper
import frontend.helpers.BaseUiHelper
import frontend.pages.ProductsPage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProductsTest: BaseUiHelper() {
    val productsHelper = ProductHelper()

    @Test
    @DisplayName("Create and check products")
    fun testFiveProductsExist() {

        val listOfproducts = productsHelper.createCoffeeProduct(4)

        val products = ProductsPage()
            .open()
            .getProductItems()

        products.size shouldBe 4
        products.forEachIndexed { index, product ->
            product.name shouldBe listOfproducts[index].name
        }
    }
}