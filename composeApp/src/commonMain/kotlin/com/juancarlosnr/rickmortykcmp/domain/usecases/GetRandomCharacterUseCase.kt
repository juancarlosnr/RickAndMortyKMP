package com.juancarlosnr.rickmortykcmp.domain.usecases

import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class GetRandomCharacterUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): CharacterModel{
        val random = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }

    @OptIn(ExperimentalTime::class)
    private fun getCurrentDayOfTheYear(): String {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}