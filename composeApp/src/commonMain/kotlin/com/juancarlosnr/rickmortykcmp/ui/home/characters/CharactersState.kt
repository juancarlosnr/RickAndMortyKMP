package com.juancarlosnr.rickmortykcmp.ui.home.characters

import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel

data class CharactersState(
    val characterOfTheDay: CharacterModel? = null
)