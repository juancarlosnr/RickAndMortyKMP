package com.juancarlosnr.rickmortykcmp.di

import com.juancarlosnr.rickmortykcmp.domain.usecases.GetRandomCharacterUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacterUseCase)
}