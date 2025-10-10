package com.juancarlosnr.rickmortykcmp.domain.repositories

import androidx.paging.PagingData
import com.juancarlosnr.rickmortykcmp.data.database.entities.CharacterOfTheDayEntity
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterOfTheDayModel
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    suspend fun getCharacterDB(): CharacterOfTheDayModel?
    suspend fun saveCharacterDB(characterOfTheDayModel: CharacterOfTheDayModel)
    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
    suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel>
    fun getSavedLanguage(): String?
    fun saveLanguage(language: String)
}