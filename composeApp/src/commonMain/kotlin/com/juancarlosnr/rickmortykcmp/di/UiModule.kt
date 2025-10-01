package com.juancarlosnr.rickmortykcmp.di

import com.juancarlosnr.rickmortykcmp.ui.home.characters.CharactersViewModel
import com.juancarlosnr.rickmortykcmp.ui.home.episodes.EpisodesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
}