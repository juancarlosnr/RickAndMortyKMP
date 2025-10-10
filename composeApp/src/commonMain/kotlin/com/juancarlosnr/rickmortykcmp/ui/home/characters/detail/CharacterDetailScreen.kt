package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundPrimaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundSecondaryColor
import com.juancarlosnr.rickmortykcmp.ui.home.characters.CharactersActions
import com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components.CharacterEpisodesList
import com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components.CharacterInformation
import com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components.MainHeader
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parameterSetOf


@Composable
fun CharacterDetailScreenRoot(
    characterModel: CharacterModel,
    navigateBack:() -> Unit
) {
    val characterDetailViewModel =
        koinViewModel<CharacterDetailViewModel>(parameters = { parameterSetOf(characterModel) })

    val state by characterDetailViewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        characterDetailViewModel.characterDetailActions.collect { action ->
            when (action) {
                CharacterDetailActions.NavigateBack -> navigateBack()
            }
        }
    }

    CharacterDetailScreen(
        state = state,
        onEvent = characterDetailViewModel::onEvent
    )
}

@Composable
fun CharacterDetailScreen(
    state: CharacterDetailState,
    onEvent: (CharacterDetailEvent) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPrimaryColor)
            .verticalScroll(scrollState)
            .systemBarsPadding()

    ) {
        MainHeader(
            characterModel = state.characterModel,
            onEvent = onEvent
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(
                    10
                ))
                .background(
                    color = BackgroundSecondaryColor
                ).padding(bottom = 16.dp)
        ) {
            CharacterInformation(
                characterModel = state.characterModel
            )
            CharacterEpisodesList(
                episodes = state.episodes
            )

        }
    }
}