package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.ui.core.Pink
import com.juancarlosnr.rickmortykcmp.ui.core.extensions.aliveBackground
import com.juancarlosnr.rickmortykcmp.ui.core.extensions.aliveBorder
import com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.CharacterDetailEvent
import org.jetbrains.compose.resources.stringResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.alive
import rickandmortykmp.composeapp.generated.resources.dead
import rickandmortykmp.composeapp.generated.resources.specie

@Composable
fun CharacterHeader(
    characterModel: CharacterModel,
    onEvent: (CharacterDetailEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        IconButton(
            onClick = {
                onEvent(CharacterDetailEvent.BackClicked)
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Back",
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(
                    topStartPercent = 10,
                    topEndPercent = 10
                ))
                .background(
                    color = Color.White
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = characterModel.name,
                color = Pink,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${stringResource(Res.string.specie)} ${characterModel.specie}",
                color = Color.Black
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier
                .height(16.dp))
            Box(
                contentAlignment = Alignment.TopCenter
            ){
                Box(
                    modifier = Modifier
                        .size(205.dp)
                        .clip(CircleShape)
                        .background(Color.Black.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ){
                    AsyncImage(
                        model = characterModel.image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(190.dp)
                            .clip(CircleShape)
                            .aliveBorder(characterModel.isAlive),
                        contentScale = ContentScale.Crop
                    )
                }
                val aliveCopy = if (characterModel.isAlive) stringResource(Res.string.alive) else stringResource(Res.string.dead)
                Text(
                    text = aliveCopy.uppercase(),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clip(RoundedCornerShape(30))
                        .aliveBackground(characterModel.isAlive)
                        .padding(
                            horizontal = 6.dp,
                            vertical = 2.dp
                        )
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}