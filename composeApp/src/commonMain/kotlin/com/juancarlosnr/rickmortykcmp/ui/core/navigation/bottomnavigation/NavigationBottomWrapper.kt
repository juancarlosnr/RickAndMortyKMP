package com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.Routes
import com.juancarlosnr.rickmortykcmp.ui.home.characters.CharactersScreen
import com.juancarlosnr.rickmortykcmp.ui.home.characters.CharactersScreenRoot
import com.juancarlosnr.rickmortykcmp.ui.home.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Routes.Episodes.route
    ){
        composable(
            route = Routes.Episodes.route
        ){
            EpisodesScreen()
        }

        composable(
            route = Routes.Characters.route
        ){
            CharactersScreenRoot()
        }
    }
}