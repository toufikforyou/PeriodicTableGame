package dev.toufikforyou.periodictable.main.presentation.screens.game

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
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
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top bar always stays at top
        GameTopBar(
            correctCount = gameState.correctPlacements,
            wrongCount = gameState.wrongPlacements,
            elapsedTime = viewModel.elapsedTime
        )

        if (isLandscape) {
            // Landscape layout
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
        } else {
            // Portrait layout - RandomElements before table
            RandomElements(
                element = viewModel.currentElement,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .horizontalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .width(800.dp)
                        .fillMaxHeight()
                ) {
                    PeriodicTable(
                        placedElements = gameState.placedElements,
                        onElementClick = viewModel::onElementClick,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
