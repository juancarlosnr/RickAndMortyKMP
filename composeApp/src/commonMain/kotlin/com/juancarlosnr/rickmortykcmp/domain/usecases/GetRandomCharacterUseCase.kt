package com.juancarlosnr.rickmortykcmp.domain.usecases

import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository

class GetRandomCharacterUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(){
        val random = (1..826).random()
        repository.getSingleCharacter(random.toString())
    }
}