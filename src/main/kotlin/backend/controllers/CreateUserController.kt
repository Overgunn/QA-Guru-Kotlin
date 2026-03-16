package backend.controllers

import backend.api.models.createUser.CreateRequest
import backend.api.models.createUser.CreateResponse
import io.qameta.allure.Step
import org.example.kotlin.backend.api.endpoints.Endpoints
import retrofit2.Response

class CreateUserController: Endpoints() {

    @Step("Create user with username, email, password: {username}, {email} and password: {password}")
    fun createNewUser(username: String, email: String, password: String): Response<CreateResponse?>? {
        return createUser.postCreateUser(body = CreateRequest(username = username, email = email, password = password)).execute()
    }
}