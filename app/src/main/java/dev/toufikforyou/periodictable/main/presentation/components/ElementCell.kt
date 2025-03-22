package dev.toufikforyou.periodictable.main.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.toufikforyou.periodictable.main.domain.model.Element
import dev.toufikforyou.periodictable.main.utils.ElementColors
import dev.toufikforyou.periodictable.main.utils.SpecialCells

@Composable
fun ElementCell(
    position: Int,
    placedElement: Element?,
    onClickElement: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(32.dp)
            .border(0.5.dp, Color.Black)
            .clickable(enabled = position > 0 && placedElement == null) { onClickElement(position) }
            .background(
                if (placedElement != null) MaterialTheme.colorScheme.primaryContainer
                else getBackgroundColor(position).copy(alpha = 0.2f)
            )
            .padding(4.dp), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (position) {
                SpecialCells.LANTHANIDES -> Text(
                    text = "L",
                    fontSize = 16.sp,
                    color = ElementColors.Lanthanide,
                    fontWeight = FontWeight.Bold
                )

                SpecialCells.ACTINIDES -> Text(
                    text = "A",
                    fontSize = 16.sp,
                    color = ElementColors.Actinide,
                    fontWeight = FontWeight.Bold
                )

                else -> {
                    placedElement?.let { element ->
                        Text(
                            text = element.symbol,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.background
                        )
                    } ?: Text(
                        text = position.toString(),
                        style = MaterialTheme.typography.titleSmall,

                        )
                }
            }
        }
    }
}

private fun getBackgroundColor(position: Int): Color {
    return when (position) {
        in 3..4, in 11..12, in 19..20, in 37..38, in 55..56, in 87..88 -> ElementColors.AlkaliMetal
        in 21..30, in 39..48, in 72..80, in 104..112 -> ElementColors.TransitionMetal
        in 57..71 -> ElementColors.Lanthanide
        in 89..103 -> ElementColors.Actinide
        in 13..16, in 31..34, in 49..52, in 81..84 -> ElementColors.PostTransitionMetal
        in 5..10 -> ElementColors.Metalloid
        1 -> ElementColors.Nonmetal
        17, 35, 53, 85, 117 -> ElementColors.Halogen
        2, 18, 36, 54, 86, 118 -> ElementColors.NobleGas
        else -> ElementColors.Unknown
    }
}
