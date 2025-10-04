package com.juancarlosnr.rickmortykcmp.ui.home.episodes

import androidx.paging.PagingData
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class EpisodesState(
    val episodes: Flow<PagingData<EpisodeModel>> = emptyFlow()
)
