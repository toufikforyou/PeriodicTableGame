package dev.toufikforyou.periodictable.main.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreItem(
    label: String,
    count: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(color.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = color,
            fontWeight = FontWeight.Medium
        )
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                slideInVertically(
                    animationSpec = tween(durationMillis = 300),
                    initialOffsetY = { it }
                ) togetherWith slideOutVertically(
                    animationSpec = tween(durationMillis = 300),
                    targetOffsetY = { -it }
                )
            }
        ) { targetCount ->
            Text(
                text = targetCount.toString(),
                fontSize = 18.sp,
                color = color,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
