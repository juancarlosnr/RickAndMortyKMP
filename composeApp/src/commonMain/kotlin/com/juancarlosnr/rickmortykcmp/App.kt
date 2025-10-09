package com.juancarlosnr.rickmortykcmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.juancarlosnr.rickmortykcmp.ui.MainViewModel
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.NavigationWrapper
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    val mainViewModel = koinViewModel<MainViewModel>()
    MaterialTheme {
        NavigationWrapper()
    }
}