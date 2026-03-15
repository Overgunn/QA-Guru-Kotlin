package frontend

import frontend.helpers.BaseUiHelper
import frontend.pages.MainPage
import frontend.pages.ProductsPage
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.equals.shouldNotBeEqual
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.collections.first
import kotlin.collections.map

class ProductsCompareTest: BaseUiHelper() {

    @Test
    @DisplayName("Comparing popular items from main page with items on product page")
    fun comparePopularToProducts(){
        val mainPageItems = MainPage()
            .open()
            .getPopularProducts()
            .map{ it.name }

        MainPage().navigateHeader().clickLink("Products")

        val productPageItems = ProductsPage().getProductItems().map{ it.name }
        productPageItems shouldContainAll mainPageItems
    }

    @Test
    @DisplayName("Compare first item from main page with first item on product page")
    fun compareFirstItems(){
        val mainPageFirstItem = MainPage()
            .open()
            .getPopularProducts()
            .first()

        MainPage().navigateHeader().clickLink("Products")
        val productPageFirstItem = ProductsPage()
            .getProductItems()
            .first()

        mainPageFirstItem.name shouldBeEqual productPageFirstItem.name
        mainPageFirstItem.price shouldBeEqual productPageFirstItem.price
        mainPageFirstItem.description shouldBeEqual productPageFirstItem.description
    }


    @Test
    @DisplayName("Compare last item name from main page with last item name on product page")
    fun compareLastItems(){
        val mainPageLastItem = MainPage()
            .open()
            .getPopularProducts()
            .last()

        MainPage().navigateHeader().clickLink("Products")
        val productPageLastItem = ProductsPage()
            .getProductItems()
            .last()

        mainPageLastItem.name shouldNotBeEqual productPageLastItem.name
        mainPageLastItem.price shouldNotBeEqual productPageLastItem.price
        mainPageLastItem.description shouldNotBeEqual productPageLastItem.description
    }
}