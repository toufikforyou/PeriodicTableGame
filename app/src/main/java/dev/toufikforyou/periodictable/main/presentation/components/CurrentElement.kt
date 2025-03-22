package dev.toufikforyou.periodictable.main.presentation.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.toufikforyou.periodictable.main.domain.model.Element

@Composable
fun CurrentElement(
    element: Element,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically()
    ) {
        ElementCard(
            element = element,
            modifier = modifier.size(48.dp)
        )
    }
}
