package com.juancarlosnr.rickmortykcmp.data.remote.response

import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("status")val status:String,
    @SerialName("image")val image: String
){
    fun toDomain() : CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            image = image,
            isAlive = status.lowercase() == "alive"
        )
    }
}
