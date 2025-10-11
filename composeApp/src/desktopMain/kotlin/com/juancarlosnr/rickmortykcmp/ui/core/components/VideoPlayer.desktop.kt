package com.juancarlosnr.rickmortykcmp.ui.core.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.juancarlosnr.rickmortykcmp.ui.core.components.video.VlcNotInstalledMessage
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery
import com.juancarlosnr.rickmortykcmp.ui.core.components.video.FullVideoPlayer


@Composable
actual fun VideoPlayer(modifier: Modifier, url: String) {
    if (isVlcInstalled) {
        FullVideoPlayer(modifier, url)
    } else {
        VlcNotInstalledMessage(modifier)
    }
}

private val isVlcInstalled: Boolean by lazy {
    try {
        NativeDiscovery().discover()
    } catch (e: Exception) {
        false
    }
}





