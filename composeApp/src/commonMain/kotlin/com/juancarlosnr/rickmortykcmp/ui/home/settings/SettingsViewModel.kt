package com.juancarlosnr.rickmortykcmp.ui.home.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juancarlosnr.rickmortykcmp.domain.utils.Language
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization
import com.russhwolf.settings.Settings
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val localization: Localization,
    private val settings: Settings
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state

    private val _settingsActions = Channel<SettingsActions>()
    val settingsActions = _settingsActions.receiveAsFlow()

    companion object {
        private const val KEY_LANGUAGE = "savedLanguageIso"
    }

    init {
        getLanguage()
    }

    private fun getLanguage() {
        val savedIso = settings.getStringOrNull(KEY_LANGUAGE) ?: Language.English.iso
        val language = Language.entries.first { it.iso == savedIso }
        _state.update { it.copy(selectedLanguage = language) }
    }


    fun onEvent(settingsEvent: SettingsEvent){
        when(settingsEvent){
            is SettingsEvent.LanguageSelected -> selectLanguage(settingsEvent.language)
            SettingsEvent.BackClicked -> {
                viewModelScope.launch {
                    _settingsActions.send(SettingsActions.NavigateBack)
                }
            }
        }
    }

    fun selectLanguage(language: Language) {
        settings.putString(KEY_LANGUAGE,language.iso)
        localization.applyLanguage(language.iso)
        _state.update { state ->
            state.copy(selectedLanguage = language)
        }
    }
}
