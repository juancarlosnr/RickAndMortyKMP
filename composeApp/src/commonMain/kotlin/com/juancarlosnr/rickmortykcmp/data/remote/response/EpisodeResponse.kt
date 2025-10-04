package com.juancarlosnr.rickmortykcmp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    @SerialName("id")val id: Int,
    @SerialName("name")val name: String,
    @SerialName("episode")val episode: String,
    @SerialName("characters")val characters:List<String>

)