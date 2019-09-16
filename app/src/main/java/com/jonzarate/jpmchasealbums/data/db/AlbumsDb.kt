package com.jonzarate.jpmchasealbums.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Album::class], version = 1, exportSchema = false)
abstract class AlbumsDb : RoomDatabase() {

    abstract fun albumsDao() : AlbumsDao

}