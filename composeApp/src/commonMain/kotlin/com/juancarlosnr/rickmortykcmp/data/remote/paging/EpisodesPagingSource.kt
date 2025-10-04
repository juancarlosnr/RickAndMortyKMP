package com.juancarlosnr.rickmortykcmp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.juancarlosnr.rickmortykcmp.data.mappers.response.toEpisodeModel
import com.juancarlosnr.rickmortykcmp.data.remote.ApiService
import com.juancarlosnr.rickmortykcmp.domain.model.EpisodeModel
import kotlinx.io.IOException

class EpisodesPagingSource(private val api: ApiService): PagingSource<Int, EpisodeModel>(){
    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
       return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        return try {
            val page = params.key ?: 1
            val response = api.getAllEpisodes(page)
            val episodes = response.result

            val prev = if (page == 1) null else page - 1
            val next = if (response.info.next != null) page + 1 else null
            LoadResult.Page(
                data = episodes.map { episode ->
                    episode.toEpisodeModel()
                },
                prevKey = prev,
                nextKey = next
            )
        }catch (exception: IOException){
            LoadResult.Error(exception)
        }
    }

}