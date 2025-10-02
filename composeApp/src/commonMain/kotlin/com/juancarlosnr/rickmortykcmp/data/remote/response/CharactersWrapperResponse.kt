package com.juancarlosnr.rickmortykcmp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersWrapperResponse(
    @SerialName("info") val info: InfoResponse,
    @SerialName("results") val results: List<CharacterResponse>
)