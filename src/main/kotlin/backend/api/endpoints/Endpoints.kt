package org.example.kotlin.backend.api.endpoints

import backend.api.RetrofitClient
import backend.api.endpoints.UserEndpoints

open class Endpoints {
    protected val auth: AuthEndpoints by lazy { RetrofitClient.createService(AuthEndpoints::class.java) }

    protected val users: UserEndpoints by lazy { RetrofitClient.createService(UserEndpoints::class.java) }
}