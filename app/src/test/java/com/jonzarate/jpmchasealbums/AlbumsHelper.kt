package com.jonzarate.jpmchasealbums

import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.data.net.AlbumsResponse

object AlbumsHelper {

    const val SEARCH_1_RESULT = "Appetite"
    const val SEARCH_2_RESULT = "T"

    fun getAlbumResponse() = AlbumsResponse().apply{
       getAlbumSet().forEach { album ->
           add(com.jonzarate.jpmchasealbums.data.net.Album(album.id, album.title))
       }
    }

    fun getAlbumSet() = arrayListOf<Album>(
        Album(0, "Michael Jackson - Thriller"),
        Album(1, "AC/DC - Back In Black"),
        Album(2, "Linkin Park - Hybrid Theory"),
        Album(3, "Guns N' Roses - Appetite for Destruction"),
        Album(4, "Bruno Mars - 24K Magic")
    )
}