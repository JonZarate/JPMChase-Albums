package com.jonzarate.jpmchasealbums.view.albums

import com.jonzarate.jpmchasealbums.AlbumsHelper
import com.jonzarate.jpmchasealbums.model.AlbumsRepository
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = "AndroidManifest.xml", packageName = "com.jonzarate.jpmchasealbums", sdk = [21])
class AlbumsViewModelTests {

    private val repo = mock(AlbumsRepository::class.java)

    private fun createViewModel() = AlbumsViewModel(repo)

    @Before
    fun setup () {
        Mockito.`when`(repo.getAlbums()).thenReturn(AlbumsHelper.getAlbumSet())
    }

    @After
    fun reset () {
        Mockito.reset(repo)
    }

    @Test
    fun test_AlbumsDownloadedOnStart() {
        createViewModel()
        verify(repo, times(1)).getAlbums()
    }
}
