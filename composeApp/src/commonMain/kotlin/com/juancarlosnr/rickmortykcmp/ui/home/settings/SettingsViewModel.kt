package com.juancarlosnr.rickmortykcmp.ui.home.settings

import androidx.lifecycle.ViewModel
import com.juancarlosnr.rickmortykcmp.domain.utils.Language
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SettingsViewModel(
    private val localization: Localization
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state

    fun onEvent(settingsEvent: SettingsEvent){
        when(settingsEvent){
            is SettingsEvent.LanguageSelected -> selectLanguage(settingsEvent.language)
        }
    }

    fun selectLanguage(language: Language) {
        _state.update { state ->
            localization.applyLanguage(language.iso)
            state.copy(selectedLanguage = language)
        }
    }
}
