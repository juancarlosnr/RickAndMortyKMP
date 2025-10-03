package com.juancarlosnr.rickmortykcmp.di

import com.juancarlosnr.rickmortykcmp.data.database.RickMortyDatabase
import com.juancarlosnr.rickmortykcmp.database.data.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase> { getDatabase() }
    }
}