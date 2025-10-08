package com.juancarlosnr.rickmortykcmp.ui.home.characters.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.cash.paging.compose.LazyPagingItems
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundPrimaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.DefaultTextColor
import com.juancarlosnr.rickmortykcmp.ui.core.Green
import com.juancarlosnr.rickmortykcmp.ui.core.components.paging.PagingType
import com.juancarlosnr.rickmortykcmp.ui.core.components.paging.PagingWrapper
import com.juancarlosnr.rickmortykcmp.ui.home.characters.CharactersEvent

@Composable
fun CharactersGridList(
    characterOfTheDay: CharacterModel?,
    characters: LazyPagingItems<CharacterModel>,
    onEvent: (CharactersEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPrimaryColor)
            .padding(horizontal = 16.dp),
    ) {
        PagingWrapper(
            pagingType = PagingType.VERTICAL_GRID,
            pagingItems = characters,
            initialView = {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(64.dp),
                        color = Color.Green
                    )
                }
            },
            itemView = { characterModel ->
                CharacterItemList(
                    characterModel = characterModel,
                    onItemSelected = { character  ->
                        onEvent(CharactersEvent.CharacterClicked(character))
                    }
                )
            },
            emptyView = {
                Text("No hay personajes")
            },
            extraItemsView = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(64.dp),
                        color = Green
                    )
                }
            },
            extraView = {
                Column {
                    Text(
                        "Characters",
                        color = DefaultTextColor,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    CharacterOfTheDay(characterOfTheDay)
                }
            }
        )
    }
}