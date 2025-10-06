package com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.ui.core.DefaultTextColor
import com.juancarlosnr.rickmortykcmp.ui.core.Green

@Composable
fun InformationDetail(
    title: String,
    detail: String
) {
    Row {
        Text(
            text = title,
            color = DefaultTextColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = detail,
            color = Green
        )
    }
}
