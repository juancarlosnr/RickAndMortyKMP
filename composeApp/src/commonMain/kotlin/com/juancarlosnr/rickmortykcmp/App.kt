package com.juancarlosnr.rickmortykcmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.NavigationWrapper

@Composable
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}