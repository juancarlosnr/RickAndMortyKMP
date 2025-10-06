package com.juancarlosnr.rickmortykcmp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("status")val status:String,
    @SerialName("image")val image: String,
    @SerialName("species")val specie: String,
    @SerialName("gender") val gender: String,
    @SerialName("origin") val origin: OriginResponse,
    @SerialName("episode") val episodes: List<String>
)