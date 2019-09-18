package com.jonzarate.jpmchasealbums.model

import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.data.db.AlbumsDb
import com.jonzarate.jpmchasealbums.data.net.AlbumsApi
import kotlinx.coroutines.runBlocking

open class AlbumsRepository (private val api: AlbumsApi, private val db: AlbumsDb) {

    open fun getAlbums() : List<Album> {
        // Read local database
        val localAlbums = db.albumsDao().getAlbums()
        if (localAlbums.isEmpty()) {

            // Fetch from net
            try {
                return runBlocking {
                    val albumsResponse = api.getAlbums()
                    val convertedAlbums = albumsResponse
                        .sortedBy { album -> album.title}
                        .map { album -> Album(album.id, album.title) }


                    // Save downloaded albums
                    db.albumsDao().insertAll(convertedAlbums)
                    convertedAlbums
                }
            } catch (e: Exception) {
            }
        }

        return localAlbums
    }

}