package dev.toufikforyou.periodictable.main.presentation.components.table

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.toufikforyou.periodictable.main.domain.model.Element
import dev.toufikforyou.periodictable.main.presentation.components.ElementCell
import dev.toufikforyou.periodictable.main.presentation.components.EmptyCell
import dev.toufikforyou.periodictable.main.utils.actinideRow
import dev.toufikforyou.periodictable.main.utils.lanthanideRow
import dev.toufikforyou.periodictable.main.utils.periodicTableRows

@Composable
fun PeriodicTable(
    placedElements: Map<Int, Element>,
    onElementClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(18),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(8.dp)
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
        items(18) { EmptyCell() }

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