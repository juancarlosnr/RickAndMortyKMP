package com.juancarlosnr.rickmortykcmp.ui.home.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juancarlosnr.rickmortykcmp.domain.utils.Language
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization
import com.juancarlosnr.rickmortykcmp.ui.home.characters.CharactersActions
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val localization: Localization
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state

    private val _settingsActions = Channel<SettingsActions>()
    val settingsActions = _settingsActions.receiveAsFlow()

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
        _state.update { state ->
            localization.applyLanguage(language.iso)
            state.copy(selectedLanguage = language)
        }
    }
}
