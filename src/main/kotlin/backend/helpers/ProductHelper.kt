package backend.helpers

import backend.api.models.products.CreateProductRequest
import backend.controllers.Controllers
import io.qameta.allure.Step

class ProductHelper: Controllers() {

    @Step("Create a number of coffee products: {count}")
    fun createCoffeeProduct(count: Int): List<CreateProductRequest> {
        val listOfProducts = mutableListOf<CreateProductRequest>()
        for (i in 1..count){
            listOfProducts.add(CreateProductRequest("Coffee #$i", description = "Description for coffee product #$i", price = i.toDouble()))
        }

        listOfProducts.forEach {
        products.createProduct(product = it)
        }

        return listOfProducts.toList()
    }

    @Step("Create a number of tea products: {count}")
    fun createTeaProduct(count: Int): List<CreateProductRequest> {
        val listOfProducts = mutableListOf<CreateProductRequest>()
        for (i in 1..count){
            listOfProducts.add(CreateProductRequest("Tea #$i", description = "Description for tea product #$i", price = i.toDouble()))
        }

        listOfProducts.forEach {
            products.createProduct(product = it)
        }

        return listOfProducts.toList()
    }
}