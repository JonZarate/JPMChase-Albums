package com.jonzarate.jpmchasealbums.view.albums

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jonzarate.jpmchasealbums.Injector
import com.jonzarate.jpmchasealbums.R
import com.jonzarate.jpmchasealbums.databinding.FragmentAlbumsBinding

class AlbumsFragment : Fragment() {

    companion object {
        fun newInstance() : AlbumsFragment {
            return AlbumsFragment()
        }
    }

    private lateinit var viewmodel : AlbumsViewModel
    private val adapter = AlbumsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = Injector.getAlbumsViewModelFactory(requireContext())
        viewmodel =
            ViewModelProviders.of(this, factory).get(AlbumsViewModel::class.java)

        val binding = FragmentAlbumsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@AlbumsFragment
        }

        setList(binding)
        setListeners(binding)
        setObservers(viewmodel)

        return binding.root
    }

    private fun setList(binding: FragmentAlbumsBinding) {
        with(binding.albumList){
            adapter = this@AlbumsFragment.adapter
        }
    }

    private fun setListeners(binding: FragmentAlbumsBinding) {
        binding.search.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewmodel.onTyped(s.toString())
            }
        })
    }

    private fun setObservers(viewModel: AlbumsViewModel) {
        viewModel.albums.observe(this, Observer { albumList ->
            with (adapter){
                albums.clear()
                albums.addAll(albumList)
                notifyDataSetChanged()
            }
        })
    }
}
