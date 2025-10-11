package com.juancarlosnr.rickmortykcmp.ui.core.components.paging

import androidx.compose.runtime.Composable
import app.cash.paging.compose.LazyPagingItems

@Composable
expect fun<T: Any> LazyRowTarget(
    pagingItems: LazyPagingItems<T>,
    itemView:@Composable (T) -> Unit,
    extraView: @Composable () -> Unit = {}
)