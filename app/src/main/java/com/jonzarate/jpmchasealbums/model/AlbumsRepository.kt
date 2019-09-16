package com.jonzarate.jpmchasealbums.model

import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.data.db.AlbumsDb
import com.jonzarate.jpmchasealbums.data.net.AlbumsApi

class AlbumsRepository (private val api: AlbumsApi, private val db: AlbumsDb) {

    suspend fun getAlbums() : List<Album> {
        try {
            val albumsResponse = api.getAlbums()
            val convertedAlbums = albumsResponse
                .map { album -> Album(album.id, album.title) }

            db.albumsDao().insertAll(convertedAlbums)
        } catch (e: Exception) {  }

        return db.albumsDao().getAlbums()
    }

}