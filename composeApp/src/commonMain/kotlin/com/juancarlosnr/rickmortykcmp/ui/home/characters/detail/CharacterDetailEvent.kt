package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail

sealed interface CharacterDetailEvent {
    data object BackClicked: CharacterDetailEvent
}