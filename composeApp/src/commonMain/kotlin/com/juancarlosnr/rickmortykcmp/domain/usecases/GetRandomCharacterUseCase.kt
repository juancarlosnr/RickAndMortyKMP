package com.juancarlosnr.rickmortykcmp.domain.usecases

import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository

class GetRandomCharacterUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): CharacterModel{
        val random = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }
}