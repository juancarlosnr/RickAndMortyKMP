package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail

import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel

data class CharacterDetailState(
    val characterModel: CharacterModel,
    val episodes:List<EpisodeModel>? = null
)
