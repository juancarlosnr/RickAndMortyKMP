package com.juancarlosnr.rickmortykcmp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    val id: Int,
    val name: String,
    val episode: String,
    val characters:List<String>

)