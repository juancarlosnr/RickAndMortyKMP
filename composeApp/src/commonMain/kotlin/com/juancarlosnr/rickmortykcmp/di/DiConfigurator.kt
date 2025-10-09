package com.juancarlosnr.rickmortykcmp.di

import com.russhwolf.settings.Settings
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect fun platformModule(): Module
expect fun targetModule(): Module

expect fun settingsModule(): Module
fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            uiModule,
            domainModule,
            dataModule,
            platformModule(),
            targetModule(),
            settingsModule()
        )
    }
}