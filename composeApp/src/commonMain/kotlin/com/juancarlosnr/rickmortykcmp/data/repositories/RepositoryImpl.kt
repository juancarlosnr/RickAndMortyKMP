package com.juancarlosnr.rickmortykcmp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingData
import app.cash.paging.PagingConfig
import com.juancarlosnr.rickmortykcmp.data.database.RickMortyDatabase
import com.juancarlosnr.rickmortykcmp.data.mappers.entities.toCharacterOfTheDayModel
import com.juancarlosnr.rickmortykcmp.data.mappers.model.toCharacterOfTheDayEntity
import com.juancarlosnr.rickmortykcmp.data.mappers.response.toCharacterModel
import com.juancarlosnr.rickmortykcmp.data.mappers.response.toEpisodeModel
import com.juancarlosnr.rickmortykcmp.data.remote.ApiService
import com.juancarlosnr.rickmortykcmp.data.remote.paging.CharactersPagingSource
import com.juancarlosnr.rickmortykcmp.data.remote.paging.EpisodesPagingSource
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterOfTheDayModel
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val episodesPagingSource: EpisodesPagingSource,
    private val rickMortyDatabase: RickMortyDatabase
) : Repository {

    companion object{
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 4
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toCharacterModel()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = MAX_ITEMS,
                prefetchDistance = PREFETCH_ITEMS
            ),
            pagingSourceFactory = {
                charactersPagingSource
            }
        ).flow
    }

    override suspend fun getCharacterDB(): CharacterOfTheDayModel? {
        return rickMortyDatabase.getPreferencesDAO().getCharacterOfTheDayDB()
            ?.toCharacterOfTheDayModel()
    }

    override suspend fun saveCharacterDB(characterOfTheDayModel: CharacterOfTheDayModel) {
        rickMortyDatabase.getPreferencesDAO()
            .saveCharacter(characterOfTheDayModel.toCharacterOfTheDayEntity())
    }

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = MAX_ITEMS,
                prefetchDistance = PREFETCH_ITEMS
            ),
            pagingSourceFactory = { episodesPagingSource }
        ).flow
    }

    override suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel> {
        return when{
            episodes.isEmpty() -> emptyList()
            episodes.size > 1 -> {
                apiService.getEpisodesForCharacter(episodes.joinToString(","))
                    .map { episodeResponse ->
                        episodeResponse.toEpisodeModel()
                    }
            }
            else -> {
                listOf(apiService.getSingleEpisode(episodes.first()).toEpisodeModel())
            }
        }
    }
}