package com.juancarlosnr.rickmortykcmp

import androidx.compose.ui.window.ComposeUIViewController
import com.juancarlosnr.rickmortykcmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}