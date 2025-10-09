package com.juancarlosnr.rickmortykcmp.ui.core.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.juancarlosnr.rickmortykcmp.domain.model.CharacterModel
import com.juancarlosnr.rickmortykcmp.domain.utils.Language
import com.juancarlosnr.rickmortykcmp.ui.home.HomeScreen
import com.juancarlosnr.rickmortykcmp.ui.home.characters.detail.CharacterDetailScreenRoot
import com.juancarlosnr.rickmortykcmp.ui.home.settings.SettingsScreenRoot
import kotlinx.serialization.json.Json

@Composable
fun NavigationWrapper(){
    val mainNavController = rememberNavController()

    NavHost(
        modifier = Modifier.statusBarsPadding(),
        navController = mainNavController,
        startDestination = Routes.Home.route
    ){
        composable(route = Routes.Home.route){
            HomeScreen(
                mainNavController = mainNavController,
                navigateToSettings =    {
                    mainNavController.navigate(Settings)
                }
            )
        }
        composable<CharacterDetail>{ navBackStackEntry ->
            val characterDetailEncoding = navBackStackEntry.toRoute<CharacterDetail>()
            val characterModel = Json.decodeFromString<CharacterModel>(characterDetailEncoding.characterModel)
            CharacterDetailScreenRoot(
                characterModel
            )
        }

        composable<Settings>{
            SettingsScreenRoot(
                navigateBack = {
                    mainNavController.popBackStack()
                }
            )
        }
    }
}