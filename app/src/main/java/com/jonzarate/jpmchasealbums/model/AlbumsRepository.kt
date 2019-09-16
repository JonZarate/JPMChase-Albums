package com.jonzarate.jpmchasealbums.model

import androidx.lifecycle.LiveData
import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.data.db.AlbumsDb
import com.jonzarate.jpmchasealbums.data.net.AlbumsApi
import java.lang.Exception

class AlbumsRepository (private val api: AlbumsApi, private val db: AlbumsDb) {

    suspend fun getAlbums() : ArrayList<Album> {
        try {
            val albumsResponse = api.getAlbums()
            val convertedAlbums = albumsResponse.albums.map { album -> Album(album.id, album.title) }
            db.albumsDao().insertAll(convertedAlbums)
        } catch (e: Exception) {  }

        return db.albumsDao().getAlbums()
    }

}