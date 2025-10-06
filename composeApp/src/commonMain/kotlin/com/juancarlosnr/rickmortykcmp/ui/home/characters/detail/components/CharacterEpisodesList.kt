package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel

@Composable
fun CharacterEpisodesList(
    episodes: List<EpisodeModel>?
) {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            if (episodes == null) {
                CircularProgressIndicator(
                    color = Color.Green
                )
            } else {
                Column {
                    episodes.forEach { episode ->
                        EpisodeItem(episodeModel = episode)
                    }
                }
            }
        }
    }
}