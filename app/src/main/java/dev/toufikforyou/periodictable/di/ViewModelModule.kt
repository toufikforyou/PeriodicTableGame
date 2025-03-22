package dev.toufikforyou.periodictable.di

import dev.toufikforyou.periodictable.main.presentation.viewmodel.GameViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        GameViewModel(get())
    }
}
