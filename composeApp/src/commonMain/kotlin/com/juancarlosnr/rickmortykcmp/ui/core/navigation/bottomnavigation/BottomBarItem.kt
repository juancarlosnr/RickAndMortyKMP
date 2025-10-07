package com.juancarlosnr.rickmortykcmp.ui.core.navigation.bottomnavigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.juancarlosnr.rickmortykcmp.ui.core.navigation.Routes
import org.jetbrains.compose.resources.painterResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.ic_characters
import rickandmortykmp.composeapp.generated.resources.ic_player

sealed class BottomBarItem {
    abstract val route:String
    abstract val title: String
    abstract val icon: @Composable () -> Unit

    data class Episodes(
        override val route: String = Routes.Episodes.route,
        override val title: String = "Episodes",
        override val icon: @Composable () -> Unit = {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(Res.drawable.ic_player),
                contentDescription = ""
            )
        }
    ): BottomBarItem()

    data class Characters(
        override val route: String = Routes.Characters.route,
        override val title: String = "Characters",
        override val icon: @Composable () -> Unit = {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(Res.drawable.ic_characters),
                contentDescription = ""
            )
        }
    ): BottomBarItem()

}