package com.juancarlosnr.rickmortykcmp.ui.home.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import app.cash.paging.compose.collectAsLazyPagingItems
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.ui.home.characters.components.CharactersGridList
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharactersScreenRoot(
    navigateToDetail: (CharacterModel) -> Unit
) {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        charactersViewModel.charactersActions.collect { action ->
            when (action) {
                is CharactersActions.NavigateToDetail -> navigateToDetail(action.characterModel)
            }
        }
    }

    CharactersScreen(
        state = state,
        onEvent = charactersViewModel::onEvent
    )
}

@Composable
fun CharactersScreen(
    state: CharactersState,
    onEvent: (CharactersEvent) -> Unit
) {
    val characters = state.characters.collectAsLazyPagingItems()

    CharactersGridList(
        characterOfTheDay = state.characterOfTheDay,
        characters = characters,
        onEvent = onEvent
    )
}