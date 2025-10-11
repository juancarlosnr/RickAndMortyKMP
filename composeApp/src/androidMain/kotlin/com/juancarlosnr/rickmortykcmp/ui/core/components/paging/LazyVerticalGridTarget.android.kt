package com.juancarlosnr.rickmortykcmp.ui.core.components.paging

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import app.cash.paging.compose.LazyPagingItems

@Composable
actual fun<T: Any> LazyVerticalGridTarget(
    pagingItems: LazyPagingItems<T>,
    verticalGridCells: GridCells.Fixed,
    horizontalArrangement: Arrangement.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    itemView:@Composable (T) -> Unit,
    extraView: @Composable () -> Unit
){
    LazyVerticalGrid(
        columns = verticalGridCells,
        horizontalArrangement = horizontalArrangement,
        verticalArrangement = verticalArrangement
    ) {
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            extraView()
        }
        items(pagingItems.itemCount){ pos ->
            pagingItems[pos]?.let { item ->
                itemView(item)
            }
        }
    }
}