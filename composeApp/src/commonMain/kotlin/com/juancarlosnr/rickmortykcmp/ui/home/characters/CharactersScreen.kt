package com.juancarlosnr.rickmortykcmp.ui.home.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import app.cash.paging.compose.collectAsLazyPagingItems
import com.juancarlosnr.rickmortykcmp.ui.home.characters.components.CharactersGridList
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharactersScreenRoot() {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()

    CharactersScreen(
        state = state
    )
}
@Composable
fun CharactersScreen(
    state: CharactersState
) {
    val characters = state.characters.collectAsLazyPagingItems()

    CharactersGridList(state.characterOfTheDay,characters)
}