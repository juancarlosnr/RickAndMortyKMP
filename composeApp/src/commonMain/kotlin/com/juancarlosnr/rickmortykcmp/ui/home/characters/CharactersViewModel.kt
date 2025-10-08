package com.juancarlosnr.rickmortykcmp.ui.home.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository
import com.juancarlosnr.rickmortykcmp.domain.usecases.GetRandomCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(
    private val getRandomCharacterUseCase: GetRandomCharacterUseCase,
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state: StateFlow<CharactersState> = _state

    private val _charactersActions = Channel<CharactersActions>()
    val charactersActions = _charactersActions.receiveAsFlow()

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                getRandomCharacterUseCase()
            }
            _state.update { state ->
                state.copy(characterOfTheDay = result)
            }
        }

        getAllCharacters()
    }

    fun onEvent(charactersEvent: CharactersEvent){
        when(charactersEvent){
            is CharactersEvent.CharacterClicked -> {
                viewModelScope.launch {
                    _charactersActions.send(CharactersActions.NavigateToDetail(charactersEvent.characterModel))
                }
            }
        }
    }

    private fun getAllCharacters() {
        _state.update { state ->
            state.copy(
                characters = repository.getAllCharacters().cachedIn(viewModelScope)
            )
        }
    }
}