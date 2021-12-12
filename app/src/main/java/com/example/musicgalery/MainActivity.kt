package com.example.musicgalery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    private lateinit var progress: ProgressBar
    private lateinit var overlay: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        val buttonLogin: AppCompatButton = findViewById(R.id.button_sign_up)
        val nameField: TextInputLayout = findViewById(R.id.input_layout_login)
        val loginField: TextInputLayout = findViewById(R.id.input_layout_email)
        val passwordField: TextInputLayout = findViewById(R.id.input_layout_password)
        val passwordConfirmationField: TextInputLayout =
            findViewById(R.id.input_layout_password_confirm)

        progress = findViewById(R.id.progress)
        overlay = findViewById(R.id.overlay_container)


        buttonLogin.setOnClickListener {
            val emailText = loginField.editText?.text.toString()
            val passwordText = passwordField.editText?.text.toString()
            val passwordConfirmationText = passwordConfirmationField.editText?.text.toString()
            val nameText = nameField.editText?.text.toString()
            viewModel.onLoginClicked(nameText, emailText, passwordText, passwordConfirmationText)
        }

        subscribeOnLiveData()
    }

    private fun subscribeOnLiveData() {
        viewModel.isLoginSuccessLiveData.observe(this, {
            val intent = Intent(this, SuccessActivity::class.java)
            startActivity(intent)
        })
        viewModel.isLoginFailedLiveData.observe(this, {
            Toast.makeText(this, "Something went wrong. Please, retry!", Toast.LENGTH_LONG).show()
        })

        viewModel.showProgressLiveData.observe(this, {
            showProgress()
        })
        viewModel.hideProgressLiveData.observe(this, {
            hideProgress()
        })

    }

    private fun hideProgress() {
        progress.isVisible = false
        overlay.isVisible = false
    }

    private fun showProgress() {
        progress.isVisible = true
        overlay.isVisible = true
    }

}