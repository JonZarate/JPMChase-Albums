package com.jonzarate.jpmchasealbums.view.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.databinding.ItemAlbumBinding

class AlbumsAdapter : RecyclerView.Adapter<AlbumViewHolder>() {

    val albums = ArrayList<Album>()

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAlbumBinding.inflate(inflater, parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.setAlbum(albums[position])
    }
}