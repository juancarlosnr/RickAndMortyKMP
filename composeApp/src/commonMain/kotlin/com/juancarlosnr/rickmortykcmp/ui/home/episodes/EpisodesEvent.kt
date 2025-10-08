package com.juancarlosnr.rickmortykcmp.ui.home.episodes

sealed interface EpisodesEvent {
    data class PlayClicked(val url: String) : EpisodesEvent
    data object CloseVideoClicked : EpisodesEvent
}