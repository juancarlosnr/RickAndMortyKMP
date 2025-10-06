package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel
import com.juancarlosnr.rickmortykcmp.ui.core.DefaultTextColor
import com.juancarlosnr.rickmortykcmp.ui.core.Green

@Composable
fun EpisodeItem(
    episodeModel: EpisodeModel
) {
    Text(
        text = episodeModel.name,
        color = Green,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = episodeModel.episode,
        color = DefaultTextColor
    )
}