package com.example.musicgalery

class AuthModelImpl : AuthService{
     override fun onLoginClicked(
        name: String,
        email: String,
        password: String,
        passwordConfirm: String
    ): Boolean {
        return emailIsValid(email) && passwordIsValid(password,passwordConfirm) && nameIsValid(name)
    }

    override fun emailIsValid(email: String):Boolean{
        return email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun passwordIsValid(password: String,
                        passwordConfirm: String):Boolean{
       return password.isNotBlank() && password.length > 5 && passwordConfirm.equals(password)
    }

    override fun nameIsValid(name: String):Boolean{
        return name.isNotBlank()
    }
}