package com.jonzarate.jpmchasealbums.data.net

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface AlbumsApi {

    @GET("albums")
    suspend fun getAlbums() : AlbumsResponse
}