package com.juancarlosnr.rickmortykcmp.ui.core.components.paging

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import com.juancarlosnr.rickmortykcmp.ui.core.Green

@Composable
actual fun <T : Any> LazyVerticalGridTarget(
    pagingItems: LazyPagingItems<T>,
    verticalGridCells: GridCells.Fixed,
    horizontalArrangement: Arrangement.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    itemView: @Composable (T) -> Unit,
    extraView: @Composable () -> Unit
) {
    val lazyState = rememberLazyGridState()

    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            state = lazyState,
            columns = GridCells.Adaptive(180.dp),
            horizontalArrangement = horizontalArrangement,
            verticalArrangement = verticalArrangement,
            modifier = Modifier.weight(1f)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                extraView()
            }
            items(pagingItems.itemCount) { pos ->
                pagingItems[pos]?.let { item ->
                    itemView(item)
                }
            }
        }

        VerticalScrollbar(
            adapter = rememberScrollbarAdapter(lazyState),
            style = LocalScrollbarStyle.current.copy(
                unhoverColor = Green.copy(alpha = 0.4f),
                hoverColor = Green
            ),
            modifier = Modifier.fillMaxHeight()
        )
    }
}
