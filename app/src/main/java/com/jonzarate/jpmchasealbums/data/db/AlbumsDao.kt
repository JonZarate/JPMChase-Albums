package com.jonzarate.jpmchasealbums.data.db

import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.Deferred

interface AlbumsDao {

    @Query("SELECT * FROM albums")
    fun getAlbums() : ArrayList<Album>

    @Update(entity = Album::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums: List<Album>) : Int

}