package com.juancarlosnr.rickmortykcmp.di

import com.juancarlosnr.rickmortykcmp.data.dabase.getDatabase
import com.juancarlosnr.rickmortykcmp.data.database.RickMortyDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module{
        single<RickMortyDatabase> { getDatabase(get()) }
    }
}