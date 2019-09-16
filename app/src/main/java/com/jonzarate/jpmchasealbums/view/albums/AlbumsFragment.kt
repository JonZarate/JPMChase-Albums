package com.jonzarate.jpmchasealbums.view.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonzarate.jpmchasealbums.Injector
import com.jonzarate.jpmchasealbums.R
import com.jonzarate.jpmchasealbums.databinding.FragmentAlbumsBinding

class AlbumsFragment : Fragment() {

    companion object {
        fun newInstance() : AlbumsFragment {
            return AlbumsFragment()
        }
    }

    private val adapter = AlbumsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val factory = Injector.getAlbumsViewModelFactory(requireContext())
        val viewmodel =
            ViewModelProviders.of(this, factory).get(AlbumsViewModel::class.java)

        val binding = FragmentAlbumsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@AlbumsFragment
        }

        setList(binding)
        setObservers(viewmodel)

        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    private fun setList(binding: FragmentAlbumsBinding) {
        with(binding.albumList){
            adapter = this@AlbumsFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setObservers(viewModel: AlbumsViewModel) {
        viewModel.albums.observe(this, Observer { albums ->
            with (adapter.album){
                clear()
                addAll(albums)
            }
        })
    }
}
