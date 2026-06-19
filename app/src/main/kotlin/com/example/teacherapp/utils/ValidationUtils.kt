package com.example.teacherapp.utils

import android.util.Patterns
import java.security.MessageDigest

object ValidationUtils {
    
    fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    fun isValidPhoneNumber(phone: String): Boolean {
        return phone.isNotEmpty() && phone.length >= 10
    }

    fun isValidName(name: String): Boolean {
        return name.isNotEmpty() && name.length >= 2
    }

    fun hashPassword(password: String): String {
        val bytes = password.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }

    fun verifyPassword(password: String, hash: String): Boolean {
        return hashPassword(password) == hash
    }
}
