package com.juancarlosnr.rickmortykcmp.ui

import androidx.lifecycle.ViewModel
import com.juancarlosnr.rickmortykcmp.domain.repositories.Repository
import com.juancarlosnr.rickmortykcmp.domain.utils.Language
import com.juancarlosnr.rickmortykcmp.domain.utils.Localization

class MainViewModel(
    private val localization: Localization,
    private val repository: Repository
) : ViewModel() {

    init {
        getLanguage()
    }

    private fun getLanguage() {
        val savedIso = repository.getSavedLanguage() ?: Language.English.iso
        val language = Language.entries.first { it.iso == savedIso }
        localization.applyLanguage(language.iso)
    }
}