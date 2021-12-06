package com.example.musicgalery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    val isLoginSuccessLiveData = MutableLiveData<Unit>()
    val isLoginFailedLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()

    private val authModel = AuthModel()

    fun onLoginClicked(
        name: String,
        email: String,
        password: String,
        passwordConfirmation: String
    ) {
        showProgressLiveData.postValue(Unit)

        val isSuccess = authModel.onLoginClicked(name, email, password, passwordConfirmation)
        if (isSuccess) {
            isLoginSuccessLiveData.postValue(Unit)
        } else {
            isLoginFailedLiveData.postValue(Unit)
        }
    }
}