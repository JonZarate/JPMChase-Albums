package com.jonzarate.jpmchasealbums.view.albums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jonzarate.jpmchasealbums.R

class AlbumsFragment : Fragment() {

    companion object {
        fun newInstance() : AlbumsFragment {
            return AlbumsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }


}
