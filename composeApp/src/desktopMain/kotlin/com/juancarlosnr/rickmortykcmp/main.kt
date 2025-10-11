package com.juancarlosnr.rickmortykcmp

import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.isTraySupported
import androidx.compose.ui.window.rememberTrayState
import com.juancarlosnr.rickmortykcmp.di.initKoin
import org.jetbrains.compose.resources.painterResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.portal

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Rick And Morty"
    ){
        var trayState = rememberTrayState()
        if(isTraySupported){
            Tray(
                state = trayState,
                icon = painterResource(Res.drawable.portal),
                menu = {
                    Item(
                        text = "Cerrar",
                        onClick = {
                            exitApplication()
                        }
                    )
                }
            )
        }
        initKoin()
        App()
    }
}