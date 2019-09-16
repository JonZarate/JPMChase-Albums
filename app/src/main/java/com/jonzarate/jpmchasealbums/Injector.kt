package com.jonzarate.jpmchasealbums

import android.content.Context
import com.jonzarate.jpmchasealbums.model.db.AlbumsDb
import com.jonzarate.jpmchasealbums.model.db.RoomHelper
import com.jonzarate.jpmchasealbums.model.net.AlbumsApi
import com.jonzarate.jpmchasealbums.model.net.RetrofitHelper
import retrofit2.converter.gson.GsonConverterFactory

object Injector {

    private const val DATABASE_NAME = "albums.db"
    private const val BASE_URL = "albums.db"

    @Volatile
    private var db: AlbumsDb? = null
    @Volatile
    private var api: AlbumsApi? = null


    fun getAlbumsDatabase(context: Context) : AlbumsDb {
        return db ?: synchronized(this) {
            RoomHelper.newInstance(context, DATABASE_NAME).apply {
                db = this
            }
        }
    }

    fun getAlbumsApi() : AlbumsApi {
        return api ?: synchronized(this) {
            RetrofitHelper.newInstance(BASE_URL, GsonConverterFactory.create()).apply {
                api = this
            }
        }
    }
}