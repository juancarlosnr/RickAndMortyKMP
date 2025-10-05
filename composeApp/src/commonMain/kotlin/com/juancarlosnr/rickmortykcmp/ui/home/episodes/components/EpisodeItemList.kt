package com.juancarlosnr.rickmortykcmp.ui.home.episodes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel
import com.juancarlosnr.rickmortykcmp.domain.model.SeasonEpisode
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.season1
import rickandmortykmp.composeapp.generated.resources.season2
import rickandmortykmp.composeapp.generated.resources.season3
import rickandmortykmp.composeapp.generated.resources.season4
import rickandmortykmp.composeapp.generated.resources.season5
import rickandmortykmp.composeapp.generated.resources.season6
import rickandmortykmp.composeapp.generated.resources.season7

@Composable
fun EpisodeItemList(
    episode: EpisodeModel,
    onEpisodeSelected: (String) -> Unit
) {
    Column(modifier = Modifier.width(120.dp)
        .padding(horizontal = 8.dp)
        .clickable {
            onEpisodeSelected(episode.videoUrl)
        }) {
        Image(
            modifier = Modifier.height(180.dp).fillMaxWidth(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            painter = painterResource(
                getSeasonImage(
                    episode.season
                )
            )
        )
    }
}

fun getSeasonImage(seasonEpisode: SeasonEpisode): DrawableResource {
    return when (seasonEpisode) {
        SeasonEpisode.SEASON_1 -> Res.drawable.season1
        SeasonEpisode.SEASON_2 -> Res.drawable.season2
        SeasonEpisode.SEASON_3 -> Res.drawable.season3
        SeasonEpisode.SEASON_4 -> Res.drawable.season4
        SeasonEpisode.SEASON_5 -> Res.drawable.season5
        SeasonEpisode.SEASON_6 -> Res.drawable.season6
        SeasonEpisode.SEASON_7 -> Res.drawable.season7
        SeasonEpisode.SEASON_8 -> Res.drawable.season7
        SeasonEpisode.UNKNOWN -> Res.drawable.season1
    }
}