package com.juancarlosnr.rickmortykcmp.data.dabase

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import com.juancarlosnr.rickmortykcmp.data.database.DATABASE_NAME
import com.juancarlosnr.rickmortykcmp.data.database.RickMortyDatabase
import kotlinx.coroutines.Dispatchers

fun getDatabase(context: Context): RickMortyDatabase{
    val dbFile = context.getDatabasePath(DATABASE_NAME)
    return Room.databaseBuilder<RickMortyDatabase>(context,dbFile.absolutePath)
        .setDriver(AndroidSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}