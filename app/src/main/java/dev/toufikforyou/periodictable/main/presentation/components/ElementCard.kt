package dev.toufikforyou.periodictable.main.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.toufikforyou.periodictable.main.domain.model.Element
import dev.toufikforyou.periodictable.main.utils.ElementColors

@Composable
fun ElementCard(
    element: Element, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.size(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(getElementColor(element.category))
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = element.atomicNumber.toString(),
                style = MaterialTheme.typography.labelSmall,
                color = Color.Black
            )
            Text(
                text = element.symbol,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
        }
    }
}

private fun getElementColor(category: String): Color {
    return when (category) {
        "ALKALI_METAL" -> ElementColors.AlkaliMetal
        "ALKALINE_EARTH_METAL" -> ElementColors.AlkalineEarthMetal
        "TRANSITION_METAL" -> ElementColors.TransitionMetal
        "POST_TRANSITION_METAL" -> ElementColors.PostTransitionMetal
        "METALLOID" -> ElementColors.Metalloid
        "NONMETAL" -> ElementColors.Nonmetal
        "HALOGEN" -> ElementColors.Halogen
        "NOBLE_GAS" -> ElementColors.NobleGas
        "LANTHANIDE" -> ElementColors.Lanthanide
        "ACTINIDE" -> ElementColors.Actinide
        else -> Color.LightGray
    }
}
