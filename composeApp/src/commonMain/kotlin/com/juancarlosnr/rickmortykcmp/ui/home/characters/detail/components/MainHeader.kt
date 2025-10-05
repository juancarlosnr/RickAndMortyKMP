package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import org.jetbrains.compose.resources.painterResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.space

@Composable
fun MainHeader(
    characterModel: CharacterModel
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ){
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(Res.drawable.space),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
        CharacterHeader(
            characterModel = characterModel
        )
    }
}

