package com.juancarlosnr.rickmortykcmp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characteroftheday")
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: Int,
    val name:String,
    val isAlive: Boolean,
    val image: String,
    val selectedDate: String,
    val specie: String
)