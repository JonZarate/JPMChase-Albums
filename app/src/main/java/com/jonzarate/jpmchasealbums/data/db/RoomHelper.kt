package com.jonzarate.jpmchasealbums.data.db

import android.content.Context
import androidx.room.Room

object RoomHelper {
    fun newInstance(context: Context, name: String): AlbumsDb {
        return Room.databaseBuilder(context, AlbumsDb::class.java, name).build()
    }
}