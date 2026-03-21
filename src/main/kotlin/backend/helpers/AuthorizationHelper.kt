package backend.helpers

import backend.api.extension.Extensions.Companion.getAsObject
import backend.api.extension.Extensions.Companion.toBearer
import backend.controllers.Controllers
import io.qameta.allure.Step
import org.example.kotlin.backend.api.models.auth.defaulAdmin

class AuthorizationHelper: Controllers() {

    @Step("Get authorization token")
    fun getToken(email: String, password: String): String {
        return auth.login(email, password).getAsObject().accessToken.toBearer()
    }

    @Step("Get admin token")
    fun getAdminToken(): String {
        return auth.login(email = defaulAdmin.email, password = defaulAdmin.password).getAsObject().accessToken.toBearer()
    }
}