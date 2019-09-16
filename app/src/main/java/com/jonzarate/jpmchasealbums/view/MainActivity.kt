package com.jonzarate.jpmchasealbums.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jonzarate.jpmchasealbums.R
import com.jonzarate.jpmchasealbums.view.albums.AlbumsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = AlbumsFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }
}
