package com.juancarlosnr.rickmortykcmp.ui.home.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juancarlosnr.rickmortykcmp.ui.home.settings.components.LanguageRow
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.selected_language

@Composable
fun SettingsScreenRoot(
    navigateBack:() -> Unit
) {
    val settingsViewModel = koinViewModel<SettingsViewModel>()
    val state by settingsViewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        settingsViewModel.settingsActions.collect { action ->
            when (action) {
                SettingsActions.NavigateBack -> {
                    navigateBack()
                }
            }
        }
    }

    SettingsScreen(
        state = state,
        onEvent = settingsViewModel::onEvent
    )
}

@Composable
fun SettingsScreen(
    state: SettingsState,
    onEvent: (SettingsEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = {
                onEvent(SettingsEvent.BackClicked)
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(Res.string.selected_language),
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        state.availableLanguages.forEach { language ->
            LanguageRow(
                language = language,
                isSelected = language == state.selectedLanguage,
                currentLanguageIso = state.selectedLanguage.iso,
                onSelect = {
                    onEvent(SettingsEvent.LanguageSelected(it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
