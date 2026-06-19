package com.example.teacherapp

import android.app.Application
import java.util.Locale

class TeacherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        loadSavedLanguage()
    }

    private fun loadSavedLanguage() {
        val prefs = getSharedPreferences("TeacherAppPrefs", MODE_PRIVATE)
        val language = prefs.getString("language", "ar") ?: "ar"
        setAppLocale(language)
    }

    fun setAppLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        
        val config = resources.configuration
        config.setLocale(locale)
        createConfigurationContext(config)
        
        val prefs = getSharedPreferences("TeacherAppPrefs", MODE_PRIVATE)
        prefs.edit().putString("language", language).apply()
    }
}
