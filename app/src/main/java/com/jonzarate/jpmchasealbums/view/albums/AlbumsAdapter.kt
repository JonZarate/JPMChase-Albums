package com.jonzarate.jpmchasealbums.view.albums

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.jpmchasealbums.data.db.Album

class AlbumsAdapter : RecyclerView.Adapter<AlbumViewHolder>() {

    val album = ArrayList<Album>()

    override fun getItemCount(): Int {
        return album.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}