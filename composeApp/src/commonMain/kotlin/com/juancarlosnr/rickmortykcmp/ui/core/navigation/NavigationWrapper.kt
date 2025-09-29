package com.juancarlosnr.rickmortykcmp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juancarlosnr.rickmortykcmp.ui.home.HomeScreen

@Composable
fun NavigationWrapper(){
    val mainNavController = rememberNavController()

    NavHost(
        navController = mainNavController,
        startDestination = Routes.Home.route
    ){
        composable(route = Routes.Home.route){
            HomeScreen()
        }
    }
}