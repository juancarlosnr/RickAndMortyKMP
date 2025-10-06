package com.juancarlosnr.rickmortykcmp.ui.home.characters.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.ui.core.Green
import org.jetbrains.compose.resources.painterResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.rickface

@Composable
fun CharacterItemList(
    characterModel: CharacterModel,
    onItemSelected: (CharacterModel) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24))
            .border(2.dp, Green, shape = RoundedCornerShape(0,24,0,24))
            .fillMaxWidth()
            .height(150.dp)
            .clickable{
                onItemSelected(characterModel)
            },
        contentAlignment = Alignment.BottomCenter
    ){
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = characterModel.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(Res.drawable.rickface)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(brush = Brush.verticalGradient(
                    listOf(
                        Color.Black.copy(0f),
                        Color.Black.copy(0.6f),
                        Color.Black.copy(1f)
                    )
                )),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = characterModel.name,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}