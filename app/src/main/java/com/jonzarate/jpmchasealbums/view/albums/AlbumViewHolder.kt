package com.jonzarate.jpmchasealbums.view.albums

import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.databinding.ItemAlbumBinding

class AlbumViewHolder(
    private val binding: ItemAlbumBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setAlbum(album: Album) {
        binding.album = album
    }

}