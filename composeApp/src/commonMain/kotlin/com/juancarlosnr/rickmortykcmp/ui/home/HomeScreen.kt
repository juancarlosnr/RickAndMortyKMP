package com.juancarlosnr.rickmortykcmp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundPrimaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundSecondaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.BackgroundTertiaryColor
import com.juancarlosnr.rickmortykcmp.ui.core.DefaultTextColor
import com.juancarlosnr.rickmortykcmp.ui.core.Green
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.BottomBarItem
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.NavigationBottomWrapper
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation.getBottomBarItems
import org.jetbrains.compose.resources.painterResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.ricktoolbar

@Composable
fun HomeScreen(mainNavController: NavHostController) {
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
            TopBar()
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

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundPrimaryColor),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .padding(start = 16.dp, top = 32.dp, bottom = 8.dp),
            painter = painterResource(Res.drawable.ricktoolbar),
            contentDescription = null
        )
    }
}

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