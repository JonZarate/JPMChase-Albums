package com.jonzarate.jpmchasealbums.data.db

import androidx.room.RoomDatabase

abstract class AlbumsDb : RoomDatabase() {

    abstract fun albumsDao() : AlbumsDao

}