package com.ibrahimethemsen.turkiyefinans.turkiyefinans.androidhello.register

import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    fun isCheckRegister(
        email: String?,
        password: String?,
        securityPassword: String?,
        nickName: String?,
        gender: String?
    ): Boolean {
        return isCheckEditText(email) &&
                isCheckEditText(password) &&
                isCheckEditText(securityPassword) &&
                isCheckEditText(nickName) &&
                isCheckEditText(gender)
    }

    private fun isCheckEditText(stringValue: String?): Boolean {
        return !stringValue.isNullOrBlank() && stringValue.isNotEmpty()
    }
}

