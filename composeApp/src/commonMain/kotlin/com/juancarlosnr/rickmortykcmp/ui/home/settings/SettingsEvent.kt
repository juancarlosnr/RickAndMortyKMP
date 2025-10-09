package com.juancarlosnr.rickmortykcmp.ui.home.settings

import com.juancarlosnr.rickmortykcmp.domain.utils.Language

sealed interface SettingsEvent {
    data class LanguageSelected(val language: Language) : SettingsEvent
}