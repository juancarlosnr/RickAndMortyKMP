package com.juancarlosnr.rickmortykcmp.di

import com.juancarlosnr.rickmortykcmp.data.dabase.getDatabase
import com.juancarlosnr.rickmortykcmp.data.database.RickMortyDatabase
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module{
        single<RickMortyDatabase> { getDatabase(get()) }
    }
}

actual fun targetModule(): Module {
    return module {
        single<Localization> { Localization(get()) }
    }
}

actual fun settingsModule(): Module {
    return module {
        single<Settings> {
            getSettingsSharedPrefs(get())
        }
    }
}