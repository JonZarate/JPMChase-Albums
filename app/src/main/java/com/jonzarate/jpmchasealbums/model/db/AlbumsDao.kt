package com.jonzarate.jpmchasealbums.model.db

import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.Deferred

interface AlbumsDao {

    @Query("SELECT * FROM albums")
    suspend fun getAlbums() : Deferred<LiveData<ArrayList<Album>>>

    @Update(entity = Album::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(albums: List<Album>) : Int

}