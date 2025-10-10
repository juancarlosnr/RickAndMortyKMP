package com.juancarlosnr.rickmortykcmp.ui.home.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository
import com.juancarlosnr.rickmortykcmp.domain.utils.Language
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val localization: Localization,
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state

    private val _settingsActions = Channel<SettingsActions>()
    val settingsActions = _settingsActions.receiveAsFlow()

    init {
        getLanguage()
    }

    private fun getLanguage() {
        val savedIso = repository.getSavedLanguage() ?: Language.English.iso
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
        repository.saveLanguage(language = language.iso)
        localization.applyLanguage(language.iso)
        _state.update { state ->
            state.copy(selectedLanguage = language)
        }
    }
}
