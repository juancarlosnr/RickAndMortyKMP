package com.juancarlosnr.rickmortykcmp.data.mappers.entities

import com.juancarlosnr.rickmortykcmp.data.database.entities.CharacterOfTheDayEntity
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterOfTheDayModel

fun CharacterOfTheDayEntity.toCharacterOfTheDayModel(): CharacterOfTheDayModel{
    return CharacterOfTheDayModel(
        characterModel = CharacterModel(
            id = this.id,
            name = this.name,
            isAlive = this.isAlive,
            image = this.image,
            specie = this.specie
        ),
        selectedDate = this.selectedDate
    )
}