package com.juancarlosnr.rickmortykcmp.ui.home.characters

import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel

sealed interface CharactersActions {
    data class NavigateToDetail(val characterModel: CharacterModel): CharactersActions
}