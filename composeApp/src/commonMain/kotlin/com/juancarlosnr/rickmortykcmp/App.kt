package com.juancarlosnr.rickmortykcmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {

    MaterialTheme {
        NavigationWrapper()
    }
}