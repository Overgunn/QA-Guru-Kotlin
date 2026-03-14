package org.example.kotlin.backend.api.endpoints

import backend.api.RetrofitClient

open class Endpoints {
    protected val auth: AuthEndpoints by lazy { RetrofitClient.createService(AuthEndpoints::class.java) }
}