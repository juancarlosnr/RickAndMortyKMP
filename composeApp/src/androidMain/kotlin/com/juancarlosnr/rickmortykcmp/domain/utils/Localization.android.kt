package com.juancarlosnr.rickmortykcmp.domain.utils

import android.content.Context
import android.os.LocaleList
import java.util.Locale

actual class Localization(
    private val context: Context
) {
    actual fun applyLanguage(iso: String) {
        val locale = Locale(iso)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocales(LocaleList(locale))
    }
}