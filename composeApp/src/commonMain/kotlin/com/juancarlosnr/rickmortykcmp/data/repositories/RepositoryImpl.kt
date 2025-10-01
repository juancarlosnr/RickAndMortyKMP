package com.juancarlosnr.rickmortykcmp.data.repositories

import com.juancarlosnr.rickmortykcmp.data.remote.ApiService
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository

class RepositoryImpl(
    val apiService: ApiService
) : Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }
}