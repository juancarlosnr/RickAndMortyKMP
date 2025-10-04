package com.juancarlosnr.rickmortykcmp.domain.model

data class EpisodeModel(
    val id: Int,
    val name: String,
    val episode: String,
    val characters:List<String>,
    val videoUrl: String,
    val season:SeasonEpisode
)


