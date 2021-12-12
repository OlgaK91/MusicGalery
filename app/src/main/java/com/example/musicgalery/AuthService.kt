package com.example.musicgalery

interface AuthService {
    fun onLoginClicked(
        name: String,
        email: String,
        password: String,
        passwordConfirm: String
    ): Boolean

    fun emailIsValid(email: String): Boolean
    fun passwordIsValid(
        password: String,
        passwordConfirm: String
    ): Boolean

    fun nameIsValid(name: String): Boolean

}