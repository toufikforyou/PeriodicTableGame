package dev.toufikforyou.periodictable

import android.app.Application
import dev.toufikforyou.periodictable.di.viewModelModule
import dev.toufikforyou.periodictable.main.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PeriodicTableApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@PeriodicTableApp)
            modules(listOf(appModule, viewModelModule))
        }
    }
}
