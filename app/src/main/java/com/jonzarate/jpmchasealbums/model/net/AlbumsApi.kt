package com.jonzarate.jpmchasealbums.model.net

import retrofit2.http.GET

interface AlbumsApi {

    @GET("albums")
    suspend fun getAlbums() : List<AlbumsResponse>
}