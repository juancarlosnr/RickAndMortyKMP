package com.juancarlosnr.rickmortykcmp.ui.core.extensions

import com.juancarlosnr.rickmortykcmp.domain.utils.Language
import org.jetbrains.compose.resources.DrawableResource
import rickandmortykmp.composeapp.generated.resources.Res
import rickandmortykmp.composeapp.generated.resources.ic_english_language
import rickandmortykmp.composeapp.generated.resources.ic_spain_language

fun Language.flagRes(): DrawableResource {
    return when (this) {
        Language.English -> Res.drawable.ic_english_language
        Language.Spanish -> Res.drawable.ic_spain_language
    }
}

fun getLanguageName(language: Language, currentLanguageIso: String): String {
    return when (language) {
        Language.English -> if (currentLanguageIso == "es") "Inglés" else "English"
        Language.Spanish -> if (currentLanguageIso == "es") "Español" else "Spanish"
    }
}