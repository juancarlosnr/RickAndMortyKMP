package com.juancarlosnr.rickmortykcmp.ui.home.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juancarlosnr.rickmortykcmp.domain.usecases.GetRandomCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(
    private val getRandomCharacterUseCase: GetRandomCharacterUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state: StateFlow<CharactersState> = _state

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                getRandomCharacterUseCase()
            }
            _state.update { state ->
                state.copy(characterOfTheDay = result)
            }
        }
    }
}