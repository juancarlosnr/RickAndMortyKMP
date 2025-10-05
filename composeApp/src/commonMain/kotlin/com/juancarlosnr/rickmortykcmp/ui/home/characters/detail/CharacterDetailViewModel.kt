package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail

import androidx.lifecycle.ViewModel
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CharacterDetailViewModel(
    characterModel: CharacterModel
): ViewModel() {
    private val _uiState = MutableStateFlow(CharacterDetailState(characterModel))
    val uiState: StateFlow<CharacterDetailState> = _uiState




}

