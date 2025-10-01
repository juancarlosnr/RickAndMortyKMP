package com.juancarlosnr.rickmortykcmp.data.remote.response

import kotlinx.serialization.SerialName

data class CharactersWrapperResponse(
    @SerialName("info") val info: InfoResponse,
    @SerialName("results") val results: List<CharacterResponse>
)