package dev.toufikforyou.periodictable.main.presentation.screens.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.toufikforyou.periodictable.main.presentation.components.GameTopBar
import dev.toufikforyou.periodictable.main.presentation.components.RandomElements
import dev.toufikforyou.periodictable.main.presentation.components.table.PeriodicTable
import dev.toufikforyou.periodictable.main.presentation.viewmodel.GameViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = koinViewModel<GameViewModel>()
    val gameState by viewModel.gameState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp), verticalArrangement = Arrangement.SpaceBetween
    ) {
        GameTopBar(
            correctCount = gameState.correctPlacements,
            wrongCount = gameState.wrongPlacements,
            elapsedTime = viewModel.elapsedTime
        )

        Box(modifier = Modifier.fillMaxSize()) {
            PeriodicTable(
                placedElements = gameState.placedElements,
                onElementClick = viewModel::onElementClick,
                modifier = Modifier.fillMaxSize()
            )

            RandomElements(
                element = viewModel.currentElement,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 16.dp)
            )
        }
    }
}
