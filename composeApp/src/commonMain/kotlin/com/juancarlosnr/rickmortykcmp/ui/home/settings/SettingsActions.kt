package com.juancarlosnr.rickmortykcmp.ui.home.settings

sealed interface SettingsActions {
    data object NavigateBack: SettingsActions
}