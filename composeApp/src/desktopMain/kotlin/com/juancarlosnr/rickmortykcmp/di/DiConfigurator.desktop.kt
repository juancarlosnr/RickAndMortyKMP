package com.juancarlosnr.rickmortykcmp.di

import com.juancarlosnr.rickmortykcmp.data.database.getDatabase
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single { getDatabase()}
    }
}

actual fun targetModule(): Module {
    return module {
        single<Localization> { Localization() }
    }
}

actual fun settingsModule() = module {
    single<Settings> { PreferencesSettings(Preferences.userRoot()) }
}
