package com.jonzarate.jpmchasealbums.model.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun newInstance(baseUrl: String, factory: GsonConverterFactory): AlbumsApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(factory)
            .build()
            .create(AlbumsApi::class.java)
    }
}