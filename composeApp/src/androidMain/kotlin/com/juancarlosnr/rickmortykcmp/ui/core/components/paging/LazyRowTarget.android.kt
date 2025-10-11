package com.juancarlosnr.rickmortykcmp.ui.core.components.paging

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import app.cash.paging.compose.LazyPagingItems

@Composable
actual fun <T : Any> LazyRowTarget(
    pagingItems: LazyPagingItems<T>,
    itemView: @Composable ((T) -> Unit),
    extraView: @Composable () -> Unit
) {
    LazyRow {
        item {
            extraView()
        }
        items(pagingItems.itemCount){ pos ->
            pagingItems[pos]?.let { item ->
                itemView(item)
            }
        }
    }
}