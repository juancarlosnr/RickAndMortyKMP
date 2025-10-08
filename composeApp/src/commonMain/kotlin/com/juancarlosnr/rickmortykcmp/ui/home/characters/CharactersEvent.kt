package com.juancarlosnr.rickmortykcmp.ui.home.characters

import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel

sealed interface CharactersEvent {
    data class CharacterClicked(val characterModel: CharacterModel): CharactersEvent
}