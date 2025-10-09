package com.juancarlosnr.rickmortykcmp.ui.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundSecondaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundTertiaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.DefaultTextColor
import com.juancarlosnr.rickmortykcmp.ui.core.Green
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.BottomBarItem

@Composable
fun BottomNavigation(
    items: List<BottomBarItem>,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = BackgroundSecondaryColor,
        contentColor = Green
    ) {
        items.forEach { bottomBarItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Green,
                    selectedIconColor = BackgroundTertiaryColor,
                    unselectedIconColor = Green
                ),
                icon = bottomBarItem.icon,
                label = {
                    Text(
                        text = bottomBarItem.title,
                        color = DefaultTextColor
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