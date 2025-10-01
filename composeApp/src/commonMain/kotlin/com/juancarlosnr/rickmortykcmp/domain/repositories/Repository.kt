package com.juancarlosnr.rickmortykcmp.domain.repositories

import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}