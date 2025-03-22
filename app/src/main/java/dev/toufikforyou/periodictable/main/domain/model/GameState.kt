package dev.toufikforyou.periodictable.main.domain.model

data class GameState(
    val elements: List<Element> = emptyList(),
    val placedElements: Map<Int, Element> = emptyMap(),
    val correctPlacements: Int = 0,
    val wrongPlacements: Int = 0,
    val isGameComplete: Boolean = false
)