package com.jonzarate.jpmchasealbums.view.albums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jonzarate.jpmchasealbums.model.AlbumsRepository

class AlbumsViewModelFactory (private val repo: AlbumsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumsViewModel(repo) as T
    }
}