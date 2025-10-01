package com.juancarlosnr.rickmortykcmp.ui.home.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.ui.core.extensions.vertical
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharactersScreenRoot() {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()

    CharactersScreen(
        state = state
    )
}
@Composable
fun CharactersScreen(
    state: CharactersState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CharacterOfTheDay(state.characterOfTheDay)
    }
}

@Composable
fun CharacterOfTheDay(characterModel: CharacterModel? = null) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .height(400.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        if (characterModel == null) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Box(
                contentAlignment = Alignment.BottomStart
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.Green.copy(alpha = 0.5f))
                )

                AsyncImage(
                    model = characterModel.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier.fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                0f to Color.Black.copy(alpha = 0.9f),
                                0.4f to Color.White.copy(alpha = 0f)
                            )
                        )
                )
                Text(
                    text = characterModel.name,
                    fontSize = 40.sp,
                    maxLines = 1,
                    minLines = 1,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .fillMaxHeight()
                        .vertical()
                        .rotate(-90f)
                )
            }
        }
    }
}