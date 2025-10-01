package com.juancarlosnr.rickmortykcmp.ui.home.characters

import androidx.paging.PagingData
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharactersState(
    val characterOfTheDay: CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)