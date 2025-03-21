package dev.toufikforyou.periodictable.main.di

import dev.toufikforyou.periodictable.main.data.repository.GameRepositoryImpl
import dev.toufikforyou.periodictable.main.domain.repository.GameRepository
import org.koin.dsl.module

val appModule = module {
    single<GameRepository> { GameRepositoryImpl() }
}
