package com.juancarlosnr.rickmortykcmp.data.mappers.model

import com.juancarlosnr.rickmortykcmp.data.database.entities.CharacterOfTheDayEntity
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterOfTheDayModel

fun CharacterOfTheDayModel.toCharacterOfTheDayEntity(): CharacterOfTheDayEntity{
    return CharacterOfTheDayEntity(
        id = this.characterModel.id,
        name = this.characterModel.name,
        isAlive = this.characterModel.isAlive,
        image = this.characterModel.image,
        selectedDate = this.selectedDate
    )
}