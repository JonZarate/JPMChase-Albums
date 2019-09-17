package com.jonzarate.jpmchasealbums.data.net

import retrofit2.http.GET

interface AlbumsApi {

    @GET("albums")
    fun getAlbums() : AlbumsResponse
}