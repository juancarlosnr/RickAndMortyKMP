package com.juancarlosnr.rickmortykcmp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodesWrapperResponse(
    @SerialName("info")val info: InfoResponse,
    @SerialName("results")val listEpisodes:List<EpisodeResponse>
)
