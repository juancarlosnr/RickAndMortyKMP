package com.juancarlosnr.rickmortykcmp.ui.core.components.paging

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems

@Composable
fun <T: Any> PagingWrapper(
    pagingType: PagingType,
    pagingItems: LazyPagingItems<T>,
    verticalGridCells: GridCells.Fixed = GridCells.Fixed(2),
    horizontalGridCells: GridCells.Fixed = GridCells.Fixed(2),
    initialView: @Composable () -> Unit = {},
    emptyView: @Composable () -> Unit = {},
    extraItemsView: @Composable () -> Unit = {},
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
                    LazyRow {
                        items(pagingItems.itemCount){ pos ->
                            pagingItems[pos]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }
                PagingType.COLUMN -> {
                    LazyColumn {
                        items(pagingItems.itemCount){ pos ->
                            pagingItems[pos]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }
                PagingType.VERTICAL_GRID -> {
                    LazyVerticalGrid(verticalGridCells) {
                        items(pagingItems.itemCount){ pos ->
                            pagingItems[pos]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }
                PagingType.HORIZONTAL_GRID -> {
                    LazyHorizontalGrid(horizontalGridCells) {
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