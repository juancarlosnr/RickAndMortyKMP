package com.juancarlosnr.rickmortykcmp.ui.core.components.paging

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems

@Composable
expect fun<T: Any> LazyVerticalGridTarget(
    pagingItems: LazyPagingItems<T>,
    verticalGridCells: GridCells.Fixed = GridCells.Fixed(2),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(16.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(16.dp),
    itemView:@Composable (T) -> Unit,
    extraView: @Composable () -> Unit = {}
)