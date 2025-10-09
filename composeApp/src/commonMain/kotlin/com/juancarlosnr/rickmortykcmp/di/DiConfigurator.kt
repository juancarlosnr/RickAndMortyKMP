package com.juancarlosnr.rickmortykcmp.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

expect fun platformModule(): Module
expect fun targetModule(): Module
fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        config?.invoke(this)
        modules(
            uiModule,
            domainModule,
            dataModule,
            platformModule(),
            targetModule()
        )
    }
}