package dev.toufikforyou.periodictable.main.domain.repository

import dev.toufikforyou.periodictable.main.domain.model.Element
import dev.toufikforyou.periodictable.main.domain.model.GameState
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun getAllElements(): Flow<List<Element>>
    suspend fun saveGameState(gameState: GameState)
    fun getGameState(): Flow<GameState>
}