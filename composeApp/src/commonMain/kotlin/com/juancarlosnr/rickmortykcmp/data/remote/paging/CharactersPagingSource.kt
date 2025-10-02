package com.juancarlosnr.rickmortykcmp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.juancarlosnr.rickmortykcmp.data.remote.ApiService
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import kotlinx.io.IOException


class CharactersPagingSource(
    private val api: ApiService
) : PagingSource<Int, CharacterModel>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val page = params.key ?: 1
            val response = api.getAllCharacters(page)
            val characters = response.results

            val prev = if (page == 1) null else page - 1
            val next = if (response.info.next != null) page + 1 else null

            LoadResult.Page(
                data = characters.map { character -> character.toDomain() },
                prevKey = prev,
                nextKey = next
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }
    }
}
