package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail

sealed interface CharacterDetailActions {
    data object NavigateBack : CharacterDetailActions
}