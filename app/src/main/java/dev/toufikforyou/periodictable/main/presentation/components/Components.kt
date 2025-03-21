package dev.toufikforyou.periodictable.main.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun EmptyCell() {
    Box(
        modifier = Modifier
            .size(28.dp)
            .background(Color.Transparent)
    )
}

@Composable
fun EmptySpace() {
    Box(
        modifier = Modifier
            .size(10.dp)
            .background(Color.Transparent)
    )
}