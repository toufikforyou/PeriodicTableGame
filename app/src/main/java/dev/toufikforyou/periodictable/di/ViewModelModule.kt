package dev.toufikforyou.periodictable.di

import dev.toufikforyou.periodictable.main.presentation.viewmodel.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::GameViewModel)
}
