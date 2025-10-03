package com.juancarlosnr.rickmortykcmp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingData
import app.cash.paging.PagingConfig
import com.juancarlosnr.rickmortykcmp.data.database.RickMortyDatabase
import com.juancarlosnr.rickmortykcmp.data.remote.ApiService
import com.juancarlosnr.rickmortykcmp.data.remote.paging.CharactersPagingSource
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class RepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val rickMortyDatabase: RickMortyDatabase
) : Repository {

    companion object{
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 4
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
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

    override suspend fun getCharacterDB() {
        rickMortyDatabase.getPreferencesDAO().getCharacterOfTheDayDB()
    }
}