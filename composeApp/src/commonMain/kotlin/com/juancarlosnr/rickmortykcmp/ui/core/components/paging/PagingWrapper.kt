package com.juancarlosnr.rickmortykcmp.ui.core.components.paging

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import com.juancarlosnr.rickmortykcmp.ui.core.Green
import kotlin.math.max

@Composable
fun <T: Any> PagingWrapper(
    pagingType: PagingType,
    pagingItems: LazyPagingItems<T>,
    verticalGridCells: GridCells.Fixed = GridCells.Fixed(2),
    horizontalGridCells: GridCells.Fixed = GridCells.Fixed(2),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(16.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(16.dp),
    initialView: @Composable () -> Unit = {},
    emptyView: @Composable () -> Unit = {},
    extraItemsView: @Composable () -> Unit = {},
    extraView: @Composable () -> Unit = {},
    itemView: @Composable (T) -> Unit
){
    when{
        pagingItems.loadState.refresh is LoadState.Loading && pagingItems.itemCount == 0 -> {
            initialView()
        }

        pagingItems.loadState.refresh is LoadState.NotLoading && pagingItems.itemCount == 0 -> {
            emptyView()
        }

        else -> {
            when(pagingType){
                PagingType.ROW -> {
                    LazyRowTarget(
                        pagingItems = pagingItems,
                        itemView = itemView,
                        extraView = extraView
                    )
                }
                PagingType.COLUMN -> {
                    LazyColumn {
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
                PagingType.VERTICAL_GRID -> {
                   LazyVerticalGridTarget(
                       pagingItems = pagingItems,
                       verticalGridCells = verticalGridCells,
                       horizontalArrangement = horizontalArrangement,
                       verticalArrangement = verticalArrangement,
                       extraView = extraView,
                       itemView = itemView
                   )
                }
                PagingType.HORIZONTAL_GRID -> {
                    LazyHorizontalGrid(horizontalGridCells) {
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
            }

            if(pagingItems.loadState.append is LoadState.Loading){
                extraItemsView()
            }
        }
    }
}