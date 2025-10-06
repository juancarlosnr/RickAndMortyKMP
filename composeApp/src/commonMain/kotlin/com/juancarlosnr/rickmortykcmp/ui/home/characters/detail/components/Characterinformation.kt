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
                text = "ABOUT THE CHARACTER"
            )
            Spacer(modifier = Modifier.height(6.dp))
            InformationDetail("Origin",characterModel.origin)
            Spacer(modifier = Modifier.height(2.dp))
            InformationDetail("Gender",characterModel.gender)
        }
    }
}