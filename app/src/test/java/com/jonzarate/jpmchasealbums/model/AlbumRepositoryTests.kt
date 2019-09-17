package com.jonzarate.jpmchasealbums.model

import com.jonzarate.jpmchasealbums.AlbumsHelper
import com.jonzarate.jpmchasealbums.data.db.Album
import com.jonzarate.jpmchasealbums.data.db.AlbumsDao
import com.jonzarate.jpmchasealbums.data.db.AlbumsDb
import com.jonzarate.jpmchasealbums.data.net.AlbumsApi
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*

class AlbumRepositoryTests {

    private val dao = mock(AlbumsDao::class.java)
    private val db = mock(AlbumsDb::class.java)
    private val api = mock(AlbumsApi::class.java)

    private var repo = AlbumsRepository(api, db)

    @Before
    fun setup() {

    }

    @After
    fun reset() {
        Mockito.reset(db, api)
    }

    @Test
    fun test_LocalAlbums_WithoutInternet () {
        `when`(db.albumsDao()).thenReturn(dao)
        `when`(dao.getAlbums()).thenReturn(AlbumsHelper.getAlbumSet())
        `when`(api.getAlbums()).thenThrow()

        repo.getAlbums()

        verify(dao, times(1)).getAlbums()
        verify(dao, never()).insertAll(ArgumentMatchers.anyList())
        verify(api, times(1)).getAlbums()
    }

    @Test
    fun test_LocalAlbums_WithInternet () {
        `when`(db.albumsDao()).thenReturn(dao)
        `when`(dao.getAlbums()).thenReturn(AlbumsHelper.getAlbumSet())
        `when`(api.getAlbums()).thenReturn(AlbumsHelper.getAlbumResponse())

        repo.getAlbums()

        verify(dao, times(1)).getAlbums()
        verify(dao, times(1)).insertAll(ArgumentMatchers.anyList())
        verify(api, times(1)).getAlbums()
    }

    @Test
    fun test_NoAlbums_WithoutInternet () {
        `when`(db.albumsDao()).thenReturn(dao)
        `when`(dao.getAlbums()).thenReturn(emptyList<Album>())
        `when`(api.getAlbums()).thenThrow()

        repo.getAlbums()

        verify(dao, times(1)).getAlbums()
        verify(dao, never()).insertAll(ArgumentMatchers.anyList())
        verify(api, times(1)).getAlbums()
    }

    @Test
    fun test_NoAlbums_WithInternet () {
        `when`(db.albumsDao()).thenReturn(dao)
        `when`(dao.getAlbums()).thenReturn(emptyList<Album>())
        `when`(api.getAlbums()).thenReturn(AlbumsHelper.getAlbumResponse())

        repo.getAlbums()

        verify(dao, times(1)).getAlbums()
        verify(dao, times(1)).insertAll(ArgumentMatchers.anyList())
        verify(api, times(1)).getAlbums()
    }
}