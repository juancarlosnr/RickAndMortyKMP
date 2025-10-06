package com.juancarlosnr.rickmortykcmp.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.ui.home.characters.CharactersScreen
import com.juancarlosnr.rickmortykcmp.ui.home.characters.CharactersState

@Preview(showSystemUi = true)
@Composable
fun CharactersScreenPreview() {
    CharactersScreen(
        state = CharactersState(
            characterOfTheDay = CharacterModel(
                id = 1,
                name = "Rick",
                isAlive = true,
                image = "image",
                specie = "Alien",
                gender = "Male",
                origin = "Earth",
                episodes = emptyList()
            )
        ),
        onItemSelected = {

        }
    )
}