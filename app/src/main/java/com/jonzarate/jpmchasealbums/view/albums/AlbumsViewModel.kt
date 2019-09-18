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

    private var allAlbums : List<Album>? = null
    val albums = MutableLiveData<List<Album>>()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                allAlbums = repo.getAlbums()
                albums.postValue(allAlbums)
            }
        }
    }

    fun onTyped(text: String) {
        allAlbums?.filter { album -> album.title.contains(text) }.also {
            albums.postValue(it)
        }
    }
}