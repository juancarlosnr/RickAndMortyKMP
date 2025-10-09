package com.juancarlosnr.rickmortykcmp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.NavigationBottomWrapper
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.getBottomBarItems
import com.juancarlosnr.rickmortykcmp.ui.home.components.BottomNavigation
import com.juancarlosnr.rickmortykcmp.ui.home.components.TopBar

@Composable
fun HomeScreen(
    mainNavController: NavHostController,
    navigateToSettings: () -> Unit
) {
    val items = getBottomBarItems()
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                items = items,
                navController = navController
            )
        },
        topBar = {
            TopBar(
                navigateToSettings = navigateToSettings
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
        ) {
            NavigationBottomWrapper(navController,mainNavController)
        }
    }
}