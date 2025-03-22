package dev.toufikforyou.periodictable.main.utils

data class PeriodicRow(
    val elements: Map<Int, Int>, // column index to element number mapping
    val rowIndex: Int
)

object SpecialCells {
    const val LANTHANIDES = -1
    const val ACTINIDES = -2
}

val periodicTableRows = listOf(
    // Period 1
    PeriodicRow(
        elements = mapOf(0 to 1, 17 to 2),
        rowIndex = 0
    ),
    // Period 2
    PeriodicRow(
        elements = mapOf(0 to 3, 1 to 4, 12 to 5, 13 to 6, 14 to 7, 15 to 8, 16 to 9, 17 to 10),
        rowIndex = 1
    ),
    // Period 3
    PeriodicRow(
        elements = mapOf(0 to 11, 1 to 12, 12 to 13, 13 to 14, 14 to 15, 15 to 16, 16 to 17, 17 to 18),
        rowIndex = 2
    ),
    // Period 4
    PeriodicRow(
        elements = (0..17).associateWith { it + 19 },
        rowIndex = 3
    ),
    // Period 5
    PeriodicRow(
        elements = (0..17).associateWith { it + 37 },
        rowIndex = 4
    ),
    // Period 6
    PeriodicRow(
        elements = mapOf(
            0 to 55,  // Cs
            1 to 56,  // Ba
            2 to SpecialCells.LANTHANIDES,  // Lanthanides indicator
            *((3..17).map { it to (it + 69) }.toTypedArray())  // Hf to Rn
        ),
        rowIndex = 5
    ),
    // Period 7
    PeriodicRow(
        elements = mapOf(
            0 to 87,  // Fr
            1 to 88,  // Ra
            2 to SpecialCells.ACTINIDES,  // Actinides indicator
            *((3..17).map { it to (it + 101) }.toTypedArray())  // Rf to Og
        ),
        rowIndex = 6
    )
)

// f-block elements with centered ranges
val lanthanideRow = PeriodicRow(
    elements = (0..14).associateWith { it + 57 }, // La (57) to Lu (71)
    rowIndex = 8
)

val actinideRow = PeriodicRow(
    elements = (0..14).associateWith { it + 89 }, // Ac (89) to Lr (103)
    rowIndex = 9
)
