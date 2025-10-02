package com.juancarlosnr.rickmortykcmp.ui.home.characters.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel

@Composable
fun CharactersGridList(
    characterOfTheDay: CharacterModel?,
    characters: LazyPagingItems<CharacterModel>
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(
            span = {
                GridItemSpan(2)
            }
        ) {
            CharacterOfTheDay(characterOfTheDay)
        }
        when {
            characters.loadState.refresh is LoadState.Loading && characters.itemCount == 0 ->{
                //Initial loading
                item(
                    span = {
                        GridItemSpan(2)
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(64.dp),
                            color = Color.Red
                        )
                    }
                }
            }
            characters.loadState.refresh is LoadState.NotLoading && characters.itemCount == 0 -> {
                //Empty api
                item {
                    Text("No hay personajes")
                }
            }

            else -> {
                items(characters.itemCount){ pos ->
                    characters[pos]?.let { characterModel ->
                        CharacterItemList(characterModel)
                    }
                }
                if(characters.loadState.append is LoadState.Loading){
                    item(
                        span = {
                            GridItemSpan(2)
                        }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center
                        ){
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(64.dp),
                                color = Color.Red
                            )
                        }
                    }
                }
            }
        }
    }
}