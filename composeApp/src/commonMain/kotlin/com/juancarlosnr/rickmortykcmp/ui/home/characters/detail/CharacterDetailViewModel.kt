package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterDetailViewModel(
    characterModel: CharacterModel,
    val repository: Repository
): ViewModel() {
    private val _uiState = MutableStateFlow(CharacterDetailState(characterModel))
    val uiState: StateFlow<CharacterDetailState> = _uiState

    private val _characterDetailActions = Channel<CharacterDetailActions>()
    val characterDetailActions = _characterDetailActions.receiveAsFlow()

    init {
        getEpisodesForCharacter(characterModel.episodes)
    }

    fun onEvent(event: CharacterDetailEvent){
        when(event){
            CharacterDetailEvent.BackClicked -> {
                viewModelScope.launch {
                    _characterDetailActions.send(CharacterDetailActions.NavigateBack)
                }
            }
        }
    }

    private fun getEpisodesForCharacter(episodes: List<String>) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                repository.getEpisodesForCharacter(episodes)
            }
            _uiState.update { state ->
                state.copy(
                    episodes = result
                )
            }
        }
    }

}

