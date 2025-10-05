package com.juancarlosnr.rickmortykcmp.ui.home.episodes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.cash.paging.compose.collectAsLazyPagingItems
import com.juancarlosnr.rickmortykcmp.ui.core.components.paging.PagingLoadingState
import com.juancarlosnr.rickmortykcmp.ui.core.components.paging.PagingType
import com.juancarlosnr.rickmortykcmp.ui.core.components.paging.PagingWrapper
import com.juancarlosnr.rickmortykcmp.ui.home.episodes.components.EpisodeItemList
import com.juancarlosnr.rickmortykcmp.ui.home.episodes.components.EpisodePlayer
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EpisodesScreen(){
    val episodesViewModel = koinViewModel<EpisodesViewModel>()

    val state by episodesViewModel.state.collectAsState()
    val episodes = state.episodes.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PagingWrapper(
            pagingType = PagingType.ROW,
            pagingItems = episodes,
            initialView = {
                PagingLoadingState()
            },
            itemView = { episode ->
                EpisodeItemList(
                    episode = episode,
                    onEpisodeSelected = { url ->
                        episodesViewModel.onPlaySelected(url)
                    }
                )
            }
        )

        AnimatedVisibility(state.playVideo.isNotBlank()) {
            EpisodePlayer(
                url = state.playVideo,
                onCloseVideo = {
                    episodesViewModel.onCloseVideo()
                }
            )
        }
    }
}