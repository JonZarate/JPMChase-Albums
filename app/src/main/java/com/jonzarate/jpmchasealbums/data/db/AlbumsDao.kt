package com.jonzarate.jpmchasealbums.data.db

import androidx.room.*

@Dao
interface AlbumsDao {

    @Query("SELECT * FROM albums ORDER BY title ASC")
    fun getAlbums() : List<Album>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums: List<Album>)

}