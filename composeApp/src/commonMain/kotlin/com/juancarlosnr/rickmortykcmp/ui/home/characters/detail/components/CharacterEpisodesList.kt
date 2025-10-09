package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundTertiaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.components.TextTitle
import org.jetbrains.compose.resources.stringResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.episode_list_title

@Composable
fun CharacterEpisodesList(
    episodes: List<EpisodeModel>?
) {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = BackgroundTertiaryColor
        )
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            if (episodes == null) {
                CircularProgressIndicator(
                    color = Color.Green
                )
            } else {
                Column {
                    TextTitle(
                        text = stringResource(Res.string.episode_list_title)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    episodes.forEach { episode ->
                        EpisodeItem(episodeModel = episode)
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}