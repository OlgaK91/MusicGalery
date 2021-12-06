package com.example.musicgalery

class AuthModel {
    fun onLoginClicked(
        name: String,
        email: String,
        password: String,
        passwordConfirm: String
    ): Boolean {
        val isEmailValid =
            email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val passwordValid =
            password.isNotBlank() && password.length > 5 && passwordConfirm.equals(password)
        val isNameNotEmpty = name.isNotBlank()
        return isEmailValid && passwordValid && isNameNotEmpty
    }
}