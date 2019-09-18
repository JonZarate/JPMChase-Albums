package com.jonzarate.jpmchasealbums.data.net

import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit

object RetrofitHelper {
    fun newInstance(baseUrl: String, converter: Converter.Factory): AlbumsApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converter)
            .build()
            .create(AlbumsApi::class.java)
    }
}