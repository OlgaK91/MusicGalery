package com.example.musicgalery

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    val isLoginSuccessLiveData = MutableLiveData<Unit>()
    val isLoginFailedLiveData = MutableLiveData<Unit>()
    val showProgressLiveData = MutableLiveData<Unit>()
    val hideProgressLiveData = MutableLiveData<Unit>()

    private val authModel: AuthService = AuthModelImpl()

    fun onLoginClicked(
        name: String,
        email: String,
        password: String,
        passwordConfirmation: String
    ) {
        showProgressLiveData.postValue(Unit)
        Handler(Looper.getMainLooper()).postDelayed({
        val isSuccess = authModel.onLoginClicked(name, email, password, passwordConfirmation)
            hideProgressLiveData.postValue(Unit)
            if (isSuccess) {
                isLoginSuccessLiveData.postValue(Unit)
            } else {
                isLoginFailedLiveData.postValue(Unit)
            }
        }, 3000)
    }
}