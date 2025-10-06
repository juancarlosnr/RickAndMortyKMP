package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel

@Composable
fun EpisodeItem(
    episodeModel: EpisodeModel
) {
    Text(
        text = episodeModel.name
    )
    Text(
        text = episodeModel.episode
    )
}