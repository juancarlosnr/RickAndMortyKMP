package com.juancarlosnr.rickmortykcmp.di

import com.juancarlosnr.rickmortykcmp.data.database.RickMortyDatabase
import com.juancarlosnr.rickmortykcmp.database.data.getDatabase
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase> { getDatabase() }
    }
}

actual fun targetModule(): Module {
    return module {
        single<Localization> { Localization() }
    }
}

actual fun settingsModule(): Module {
    return module {
          single<Settings> { NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults) }
    }
}