package com.jonzarate.jpmchasealbums

import android.content.Context
import com.jonzarate.jpmchasealbums.data.db.AlbumsDb
import com.jonzarate.jpmchasealbums.data.db.RoomHelper
import com.jonzarate.jpmchasealbums.data.net.AlbumsApi
import com.jonzarate.jpmchasealbums.data.net.RetrofitHelper
import com.jonzarate.jpmchasealbums.model.AlbumsRepository
import com.jonzarate.jpmchasealbums.view.albums.AlbumsViewModel
import com.jonzarate.jpmchasealbums.view.albums.AlbumsViewModelFactory
import retrofit2.converter.gson.GsonConverterFactory

object Injector {

    private const val DATABASE_NAME = "albums.db"
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    @Volatile
    private var db: AlbumsDb? = null
    @Volatile
    private var api: AlbumsApi? = null
    @Volatile
    private var repo: AlbumsRepository? = null
    @Volatile
    private var factory: AlbumsViewModelFactory? = null

    private fun getAlbumsDatabase(context: Context) : AlbumsDb {
        return db ?: synchronized(this) {
            RoomHelper.newInstance(context, DATABASE_NAME).apply {
                db = this
            }
        }
    }

    private fun getAlbumsApi() : AlbumsApi {
        return api ?: synchronized(this) {
            RetrofitHelper.newInstance(BASE_URL, GsonConverterFactory.create()).apply {
                api = this
            }
        }
    }

    private fun getAlbumsRepository(context: Context) : AlbumsRepository {
        return repo ?: synchronized(this) {
            AlbumsRepository(getAlbumsApi(), getAlbumsDatabase(context)).apply {
                repo = this
            }
        }
    }

    fun getAlbumsViewModelFactory(context: Context) : AlbumsViewModelFactory {
        return factory ?: synchronized(this) {
            AlbumsViewModelFactory(getAlbumsRepository(context)).apply {
                factory = this
            }
        }
    }
}