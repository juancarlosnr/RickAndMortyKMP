package com.juancarlosnr.rickmortykcmp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.onDrag
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun UtilsScreen() {
    MouseListener()
    KeyListener()
    DragItem()
}

@Composable
fun KeyListener() {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.onPreviewKeyEvent {
            if (it.key == Key.Spacebar) {
                text = "Spacebar"
                true
            } else {
                false
            }
        }
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            }
        )
    }

}

@Composable
fun MouseListener() {
    var click by remember { mutableStateOf("Vacio") }
    Column {
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(
                    color = Color.Red
                )
                .combinedClickable(
                    onClick = {
                        click = "normal"
                    },
                    onDoubleClick = {
                        click = "doble"
                    },
                    onLongClick = {
                        click = "long"
                    }
                )
        )
        Text(
            text = "Tipo de click: "
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DragItem(){
    var currentOffset by remember { mutableStateOf(Offset(0f,0f)) }

    Box(
        modifier = Modifier
            .offset{
                IntOffset(currentOffset.x.toInt(),currentOffset.y.toInt())
            }
            .size(200.dp)
            .background(Color.Red)
            .onDrag(
                matcher = PointerMatcher.mouse(PointerButton.Primary),
                onDragStart = {
                    print("empieza el drag")
                },
                onDragEnd = {
                    print("acaba el drag")
                },
                onDrag = {
                    currentOffset += it
                }
            )
    )
}
