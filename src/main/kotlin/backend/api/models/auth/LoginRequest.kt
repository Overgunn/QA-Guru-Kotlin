package org.example.kotlin.backend.api.models.auth

data class LoginRequest(
    var email: String?,
    var password: String?
)

val defaulAdmin = LoginRequest(
    email = "admin",
    password = "admin"
)