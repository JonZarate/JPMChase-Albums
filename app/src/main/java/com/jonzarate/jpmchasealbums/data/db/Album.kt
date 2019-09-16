package com.jonzarate.jpmchasealbums.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class Album (@PrimaryKey val id: Int, val title: String)