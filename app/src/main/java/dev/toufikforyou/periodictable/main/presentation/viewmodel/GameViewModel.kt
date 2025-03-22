package dev.toufikforyou.periodictable.main.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.toufikforyou.periodictable.main.domain.model.Element
import dev.toufikforyou.periodictable.main.domain.model.GameState
import dev.toufikforyou.periodictable.main.domain.repository.GameRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel(
    private val repository: GameRepository
) : ViewModel() {

    private val _gameState = MutableStateFlow(GameState())
    val gameState = _gameState.asStateFlow()

    var elapsedTime by mutableLongStateOf(0L)
        private set

    private var currentElementIndex = 0
    val currentElement: Element?
        get() = _gameState.value.elements.getOrNull(currentElementIndex)

    init {
        startGame()
        startTimer()
    }

    private fun startGame() {
        viewModelScope.launch {
            repository.getAllElements().collect { elements ->
                _gameState.value = GameState(
                    elements = elements, placedElements = emptyMap()
                )
            }
        }
    }

    private fun startTimer() {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                elapsedTime += 1000
            }
        }
    }

    fun onElementClick(position: Int) {
        val element = currentElement
        if (element != null) {
            val isCorrect = element.atomicNumber == position

            // Only update placedElements if correct
            val currentState = _gameState.value
            _gameState.value = currentState.copy(
                placedElements = if (isCorrect) {
                    currentState.placedElements + (position to element)
                } else currentState.placedElements,
                correctPlacements = currentState.correctPlacements + (if (isCorrect) 1 else 0),
                wrongPlacements = currentState.wrongPlacements + (if (!isCorrect) 1 else 0)
            )

            // Move to next element only if correct
            if (isCorrect) {
                currentElementIndex++
                if (currentElementIndex >= currentState.elements.size) {
                    _gameState.value = _gameState.value.copy(isGameComplete = true)
                }
            }
        }
    }
}