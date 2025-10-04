package com.juancarlosnr.rickmortykcmp.ui.home.episodes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.cash.paging.compose.collectAsLazyPagingItems
import com.juancarlosnr.rickmortykcmp.ui.core.components.PagingLoadingState
import com.juancarlosnr.rickmortykcmp.ui.core.components.PagingType
import com.juancarlosnr.rickmortykcmp.ui.core.components.PagingWrapper
import com.juancarlosnr.rickmortykcmp.ui.home.episodes.components.EpisodeItemList
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EpisodesScreen(){
    val episodesViewModel = koinViewModel<EpisodesViewModel>()

    val state by episodesViewModel.state.collectAsState()
    val episodes = state.episodes.collectAsLazyPagingItems()

    Box(
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
                EpisodeItemList(episode)
            }
        )
    }
}