package com.juancarlosnr.rickmortykcmp.ui.core.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.TooltipArea
import androidx.compose.foundation.TooltipPlacement
import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.ui.core.components.video.VlcNotInstalledMessage
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery
import com.juancarlosnr.rickmortykcmp.ui.core.components.video.FullVideoPlayer


@OptIn(ExperimentalFoundationApi::class)
@Composable
actual fun VideoPlayer(modifier: Modifier, url: String) {
    TooltipArea(
        tooltip = {
            Text(
                text = "Preparado para ver R&M?",
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = Color.Gray
                    )
            )
        },
        delayMillis = 1500,
        tooltipPlacement = TooltipPlacement.CursorPoint(
            alignment = Alignment.TopStart,
            offset = DpOffset((-16).dp,56.dp)

        )
    ){
        if (isVlcInstalled) {
            FullVideoPlayer(modifier, url)
        } else {
            VlcNotInstalledMessage(modifier)
        }
    }

}

private val isVlcInstalled: Boolean by lazy {
    try {
        NativeDiscovery().discover()
    } catch (e: Exception) {
        false
    }
}





