package com.juancarlosnr.rickmortykcmp.data.mappers.response

import com.juancarlosnr.rickmortykcmp.data.remote.response.CharacterResponse
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel

fun CharacterResponse.toCharacterModel(): CharacterModel{
    return CharacterModel(
        id = this.id,
        name = this.name,
        image = this.image,
        isAlive = this.status.lowercase() == "alive",
        specie = this.specie
    )
}