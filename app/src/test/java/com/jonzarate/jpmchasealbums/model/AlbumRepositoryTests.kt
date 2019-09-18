package com.jonzarate.jpmchasealbums.model

import com.jonzarate.jpmchasealbums.AlbumsHelper
import com.jonzarate.jpmchasealbums.data.db.AlbumsDao
import com.jonzarate.jpmchasealbums.data.db.AlbumsDb
import com.jonzarate.jpmchasealbums.data.net.AlbumsApi
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.verification.VerificationMode

class AlbumRepositoryTests {

    private val dao = mock(AlbumsDao::class.java)
    private val db = mock(AlbumsDb::class.java)
    private val api = mockk<AlbumsApi>()

    private var repo = AlbumsRepository(api, db)

    @Before
    fun setup() {
        `when`(db.albumsDao()).thenReturn(dao)
    }

    @After
    fun reset() {
        Mockito.reset(db)
        clearMocks(api)
    }

    @Test
    fun if_AlbumsInDb_DoesNotFetch () {
        `when`(dao.getAlbums()).thenReturn(AlbumsHelper.getAlbumSet())
        coEvery { api.getAlbums() } throws (Exception())

        repo.getAlbums()

        verifyGetAlbums(times(1),  never(), 0)
    }

    @Test
    fun if_NoAlbumsInDb_DoesFetch () {
        val injectedAlbums = AlbumsHelper.getAlbumResponse()
        `when`(dao.getAlbums()).thenReturn(listOf())
        coEvery { api.getAlbums() } coAnswers { injectedAlbums }

        val albums = repo.getAlbums()

        assertEquals (injectedAlbums.size, albums.size)
        verifyGetAlbums(times(1),  times(1), 1)
    }

    private fun verifyGetAlbums(
        modeGetAlbums: VerificationMode, modeInsertAll: VerificationMode, intExactly: Int) {
        verify(dao, modeGetAlbums).getAlbums()
        verify(dao, modeInsertAll).insertAll(anyList())
        coVerify(exactly = intExactly) { api.getAlbums() }
    }
}