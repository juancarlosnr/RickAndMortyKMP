package com.juancarlosnr.rickmortykcmp.data.mappers.response

import com.juancarlosnr.rickmortykcmp.data.remote.response.EpisodeResponse
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel
import com.juancarlosnr.rickmortykcmp.domain.model.SeasonEpisode

fun EpisodeResponse.toEpisodeModel(): EpisodeModel {
    val season = getSeasonFromEpisodeCode(this.episode)
    return EpisodeModel(
        id = this.id,
        name = this.name,
        episode = this.episode,
        characters = this.characters.map { url ->
            url.substringAfterLast("/")
        },
        season = season,
        videoUrl = getVideoUrlFromSeason(season)
    )
}

private fun getVideoUrlFromSeason(seasonEpisode: SeasonEpisode):String{
    return when(seasonEpisode){
        SeasonEpisode.SEASON_1 -> "https://www.youtube.com/watch?v=8BEzj2kRjO8&ab_channel=RottenTomatoesTV"
        SeasonEpisode.SEASON_2 -> "https://www.youtube.com/watch?v=SXwf_9xJu5c&ab_channel=Yusuto"
        SeasonEpisode.SEASON_3 -> "https://www.youtube.com/watch?v=Bmg2vXOQ3kM&ab_channel=SeriesTrailerMP"
        SeasonEpisode.SEASON_4 -> "https://www.youtube.com/watch?v=bLI2-v264No&ab_channel=RottenTomatoesTV"
        SeasonEpisode.SEASON_5 -> "https://www.youtube.com/watch?v=yC1UxW8vcDo&ab_channel=RottenTomatoesTV"
        SeasonEpisode.SEASON_6 -> "https://www.youtube.com/watch?v=jerFRSQW9g8&ab_channel=RottenTomatoesTV"
        SeasonEpisode.SEASON_7 -> "https://www.youtube.com/watch?v=PkZtVBNkmso&ab_channel=RottenTomatoesTV"
        SeasonEpisode.SEASON_8 -> "https://www.youtube.com/watch?v=ySYnTO7leqI"
        SeasonEpisode.UNKNOWN -> "https://www.youtube.com/watch?v=8BEzj2kRjO8&ab_channel=RottenTomatoesTV"
    }
}

private fun getSeasonFromEpisodeCode(episode: String): SeasonEpisode{
    return when{
        episode.startsWith("S01") -> SeasonEpisode.SEASON_1
        episode.startsWith("S02") -> SeasonEpisode.SEASON_2
        episode.startsWith("S03") -> SeasonEpisode.SEASON_3
        episode.startsWith("S04") -> SeasonEpisode.SEASON_4
        episode.startsWith("S05") -> SeasonEpisode.SEASON_5
        episode.startsWith("S06") -> SeasonEpisode.SEASON_6
        episode.startsWith("S07") -> SeasonEpisode.SEASON_7
        episode.startsWith("S08") -> SeasonEpisode.SEASON_8
        else -> SeasonEpisode.UNKNOWN
    }
}