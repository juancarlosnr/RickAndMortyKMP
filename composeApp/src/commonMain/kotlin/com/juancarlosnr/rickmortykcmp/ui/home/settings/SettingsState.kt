package com.juancarlosnr.rickmortykcmp.ui.home.settings

import com.juancarlosnr.rickmortykcmp.domain.utils.Language

data class SettingsState(
    val selectedLanguage: Language = Language.English,
    val availableLanguages: List<Language> = Language.entries.toList()
)
