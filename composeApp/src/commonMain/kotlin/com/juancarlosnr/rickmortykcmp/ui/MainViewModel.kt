package com.juancarlosnr.rickmortykcmp.ui

import androidx.lifecycle.ViewModel
import com.juancarlosnr.rickmortykcmp.domain.utils.Language
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization
import com.russhwolf.settings.Settings

class MainViewModel(
    private val localization: Localization,
    private val settings: Settings
) : ViewModel() {

    companion object {
        private const val KEY_LANGUAGE = "savedLanguageIso"
    }

    init {
        getLanguage()
    }

    private fun getLanguage() {
        val savedIso = settings.getStringOrNull(KEY_LANGUAGE) ?: Language.English.iso
        val language = Language.entries.first { it.iso == savedIso }
        localization.applyLanguage(language.iso)
    }
}