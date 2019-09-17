package com.jonzarate.jpmchasealbums.view.albums

import com.jonzarate.jpmchasealbums.model.AlbumsRepository
import io.mockk.clearMocks
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify

open class AlbumsViewModelTests {

    private lateinit var repo: AlbumsRepository

    private fun createViewModel() = AlbumsViewModel(repo)

    @Before
    fun setup () {
        repo = mockk<AlbumsRepository>()
    }

    @After
    fun reset () {
        clearMocks(repo)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun test_AlbumsDownloadedOnStart() = runBlockingTest {
        createViewModel()
        verify(repo).getAlbums()
    }
}
