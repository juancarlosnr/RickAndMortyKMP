package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun InformationDetail(
    title: String,
    detail: String
) {
    Row {
        Text(
            text = title,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = detail,
            color = Color.Green
        )
    }
}
