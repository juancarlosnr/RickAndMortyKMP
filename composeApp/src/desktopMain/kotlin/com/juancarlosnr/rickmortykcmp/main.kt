package com.juancarlosnr.rickmortykcmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.juancarlosnr.rickmortykcmp.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Rick And Morty"
    ){
        initKoin()
        App()
    }
}