package com.jonzarate.jpmchasealbums.view.albums

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.model.AlbumsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumsViewModel(
    private val repo: AlbumsRepository
) : ViewModel() {

    val albums = MutableLiveData<List<Album>>()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                println("launching")
                albums.postValue(repo.getAlbums())
            }
        }
    }
}