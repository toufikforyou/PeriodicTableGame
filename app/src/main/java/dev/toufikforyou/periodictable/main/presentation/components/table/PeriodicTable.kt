package dev.toufikforyou.periodictable.main.presentation.components.table

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import dev.toufikforyou.periodictable.main.domain.model.Element
import dev.toufikforyou.periodictable.main.presentation.components.ElementCell
import dev.toufikforyou.periodictable.main.presentation.components.EmptyCell
import dev.toufikforyou.periodictable.main.presentation.components.EmptySpace
import dev.toufikforyou.periodictable.main.utils.actinideRow
import dev.toufikforyou.periodictable.main.utils.lanthanideRow
import dev.toufikforyou.periodictable.main.utils.periodicTableRows

@Composable
fun PeriodicTable(
    placedElements: Map<Int, Element>, onElementClick: (Int) -> Unit, modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    LazyVerticalGrid(
        columns = GridCells.Fixed(18),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(
            horizontal = if (!isLandscape) 16.dp else 4.dp, vertical = 4.dp
        )
    ) {
        // Main periodic table rows
        periodicTableRows.forEach { row ->
            items(18) { columnIndex ->
                row.elements[columnIndex]?.let { elementNumber ->
                    ElementCell(
                        position = elementNumber,
                        placedElement = placedElements[elementNumber],
                        onClickElement = onElementClick,
                        modifier = Modifier
                    )
                } ?: EmptyCell()
            }
        }

        //  spacing before f-block
        items(18) { EmptySpace() }

        // Lanthanides row - centered
        items(18) { columnIndex ->
            when (columnIndex) {
                in 2..16 -> lanthanideRow.elements[columnIndex - 2]?.let { elementNumber ->
                    ElementCell(
                        position = elementNumber,
                        placedElement = placedElements[elementNumber],
                        onClickElement = onElementClick,
                        modifier = Modifier
                    )
                } ?: EmptyCell()

                else -> EmptyCell()
            }
        }

        // Actinides row - centered
        items(18) { columnIndex ->
            when (columnIndex) {
                in 2..16 -> actinideRow.elements[columnIndex - 2]?.let { elementNumber ->
                    ElementCell(
                        position = elementNumber,
                        placedElement = placedElements[elementNumber],
                        onClickElement = onElementClick,
                        modifier = Modifier
                    )
                } ?: EmptyCell()

                else -> EmptyCell()
            }
        }
    }
}