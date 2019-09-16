package com.jonzarate.jpmchasealbums.view.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.model.AlbumsRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class AlbumsViewModel(
    private val repo: AlbumsRepository
) : ViewModel() {

    val albums = MutableLiveData<ArrayList<Album>>()

    init {
        viewModelScope.launch {
            albums.postValue(repo.getAlbums())
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}