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
        SeasonEpisode.SEASON_1 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
        SeasonEpisode.SEASON_2 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
        SeasonEpisode.SEASON_3 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
        SeasonEpisode.SEASON_4 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
        SeasonEpisode.SEASON_5 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
        SeasonEpisode.SEASON_6 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
        SeasonEpisode.SEASON_7 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
        SeasonEpisode.SEASON_8 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
        SeasonEpisode.UNKNOWN -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp.appspot.com/o/RICK%20Y%20MORTY%20(Trailer%20espan%CC%83ol)%20(1).mp4?alt=media&token=b7f5ef8f-aa58-4451-9d6c-b1ed83d7ba31"
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