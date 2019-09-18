package com.jonzarate.jpmchasealbums.view.albums

import android.os.Looper.getMainLooper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jonzarate.jpmchasealbums.AlbumsHelper
import com.jonzarate.jpmchasealbums.model.AlbumsRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = "AndroidManifest.xml", packageName = "com.jonzarate.jpmchasealbums", sdk = [21])
class AlbumsViewModelTests {

    private val repo = mock(AlbumsRepository::class.java)

    private fun createViewModel() = AlbumsViewModel(repo)

    @get:Rule
    val rule = InstantTaskExecutorRule()

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

    @Test
    fun test_TypingFiltersResults () {
        val viewmodel = createViewModel()

        // Let the ViewModel initialize
        Thread.sleep(1000)

        viewmodel.onTyped(AlbumsHelper.SEARCH_1_RESULT)
        assertEquals(1, viewmodel.albums.value?.size)

        viewmodel.onTyped(AlbumsHelper.SEARCH_2_RESULT)
        assertEquals(2, viewmodel.albums.value?.size)
    }
}
