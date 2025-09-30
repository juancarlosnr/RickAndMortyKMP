package com.juancarlosnr.rickmortykcmp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.BottomBarItem
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.NavigationBottomWrapper
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.getBottomBarItems

@Composable
fun HomeScreen(){
    val items = getBottomBarItems()
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                items = items,
                navController = navController
            )
        }
    ) {
        Box{
            NavigationBottomWrapper(navController)
        }
    }
}

@Composable
fun BottomNavigation(
    items: List<BottomBarItem>,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEach { bottomBarItem ->
            NavigationBarItem(
                icon = bottomBarItem.icon,
                label = {
                    Text(
                        text = bottomBarItem.title
                    )
                },
                onClick = {
                    navController.navigate(route = bottomBarItem.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = currentDestination?.hierarchy?.any { hierarchy ->
                    hierarchy.route == bottomBarItem.route
                } == true,
                alwaysShowLabel = false
            )
        }
    }
}