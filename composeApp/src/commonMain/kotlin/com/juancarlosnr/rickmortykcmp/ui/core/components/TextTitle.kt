package com.juancarlosnr.rickmortykcmp.ui.core.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.juancarlosnr.rickmortykcmp.ui.core.DefaultTextColor

@Composable
fun TextTitle(text: String) {
    Text(
        text = text.uppercase(),
        color = DefaultTextColor,
        fontWeight = FontWeight.Bold
    )
}
