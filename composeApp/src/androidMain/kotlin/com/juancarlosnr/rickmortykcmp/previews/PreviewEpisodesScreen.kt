package com.juancarlosnr.rickmortykcmp.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.juancarlosnr.rickmortykcmp.ui.home.episodes.EpisodesScreen
import com.juancarlosnr.rickmortykcmp.ui.home.episodes.EpisodesState

@Preview(showSystemUi = true)
@Composable
fun EpisodesScreenPreview() {
    EpisodesScreen(
        state = EpisodesState(

        ),
        onEvent = {

        }
    )
}