package com.juancarlosnr.rickmortykcmp.data.database

import androidx.room.Database
import androidx.room.ConstructedBy
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.juancarlosnr.rickmortykcmp.data.database.daos.UserPreferencesDAO
import com.juancarlosnr.rickmortykcmp.data.database.entities.CharacterOfTheDayEntity

const val DATABASE_NAME = "rm_app_database.db"

expect object RickMortyCtor: RoomDatabaseConstructor<RickMortyDatabase>
@Database(entities = [CharacterOfTheDayEntity::class], version = 1)
@ConstructedBy(RickMortyCtor::class)
abstract class RickMortyDatabase: RoomDatabase(){
    abstract fun getPreferencesDAO(): UserPreferencesDAO
}