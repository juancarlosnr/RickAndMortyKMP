package com.juancarlosnr.rickmortykcmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    val id: Int,
    val name:String,
    val isAlive: Boolean,
    val image: String,
    val specie: String
)
