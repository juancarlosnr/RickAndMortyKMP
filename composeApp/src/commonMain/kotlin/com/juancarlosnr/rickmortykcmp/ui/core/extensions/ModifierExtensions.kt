package com.juancarlosnr.rickmortykcmp.ui.core.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp

fun Modifier.vertical() = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.height, placeable.width) {
        placeable.place(
            x = -((placeable.width / 2) - (placeable.height / 2)),
            y = -((placeable.height / 2) - (placeable.width / 2))
        )
    }
}

fun Modifier.aliveBorder(isAlive: Boolean): Modifier {
    return border(4.dp, color = aliveColor(isAlive), shape = CircleShape)
}

fun Modifier.aliveBackground(isAlive: Boolean): Modifier {
    return background(color = aliveColor(isAlive))
}

private fun aliveColor(isAlive: Boolean): Color {
    val color = if (isAlive) Color.Green else Color.Red
    return color
}