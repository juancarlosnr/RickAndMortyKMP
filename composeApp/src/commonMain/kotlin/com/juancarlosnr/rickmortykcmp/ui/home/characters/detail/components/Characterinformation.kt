package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundTertiaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.components.TextTitle
import org.jetbrains.compose.resources.stringResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.character_information_title
import rickandmortykmp.composeapp.generated.resources.gender
import rickandmortykmp.composeapp.generated.resources.origin

@Composable
fun CharacterInformation(
    characterModel: CharacterModel
){
    ElevatedCard(
        modifier = Modifier
            .padding( 16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = BackgroundTertiaryColor
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            TextTitle(
                text = stringResource(Res.string.character_information_title).uppercase()
            )
            Spacer(modifier = Modifier.height(6.dp))
            InformationDetail(stringResource(Res.string.origin),characterModel.origin)
            Spacer(modifier = Modifier.height(2.dp))
            InformationDetail(stringResource(Res.string.gender),characterModel.gender)
        }
    }
}