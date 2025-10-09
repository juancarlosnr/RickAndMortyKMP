package com.juancarlosnr.rickmortykcmp.di

import android.content.Context
import com.russhwolf.settings.SharedPreferencesSettings

fun getSettingsSharedPrefs(context: Context):SharedPreferencesSettings{
    return SharedPreferencesSettings(
        context.getSharedPreferences(
            "app_prefs",
            Context.MODE_PRIVATE
        )
    )
}