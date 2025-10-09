package com.juancarlosnr.rickmortykcmp.ui.home.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juancarlosnr.rickmortykcmp.ui.home.settings.components.LanguageRow
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.selected_language

@Composable
fun SettingsScreenRoot() {
    val settingsViewModel = koinViewModel<SettingsViewModel>()
    val state by settingsViewModel.state.collectAsState()
    SettingsScreen(
        state = state,
        onEvent = settingsViewModel::onEvent
    )
}

@Composable
fun SettingsScreen(
    state: SettingsState,
    onEvent: (SettingsEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(Res.string.selected_language),
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        state.availableLanguages.forEach { language ->
            LanguageRow(
                language = language,
                isSelected = language == state.selectedLanguage,
                onSelect = {
                    onEvent(SettingsEvent.LanguageSelected(it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}