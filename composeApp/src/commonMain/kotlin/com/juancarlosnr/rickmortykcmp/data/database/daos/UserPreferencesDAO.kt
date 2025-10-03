package com.juancarlosnr.rickmortykcmp.data.database.daos

import androidx.room.Dao
import androidx.room.Query
import com.juancarlosnr.rickmortykcmp.data.database.entities.CharacterOfTheDayEntity

@Dao
interface UserPreferencesDAO {

    @Query("SELECT * FROM characteroftheday")
    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayEntity?
}