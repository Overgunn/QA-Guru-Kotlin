package org.example.kotlin.backend.api.endpoints

import backend.api.RetrofitClient
import backend.api.endpoints.CreateUserEndpoint

open class Endpoints {
    protected val auth: AuthEndpoints by lazy { RetrofitClient.createService(AuthEndpoints::class.java) }
    protected val createUser: CreateUserEndpoint by lazy { RetrofitClient.createService(CreateUserEndpoint::class.java) }
}