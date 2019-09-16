package com.jonzarate.jpmchasealbums.model.db

import androidx.room.RoomDatabase

abstract class AlbumsDb : RoomDatabase() {

    abstract fun albumsDao() : AlbumsDao

}