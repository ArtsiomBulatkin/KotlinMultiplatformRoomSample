package com.kotlinmultiplatform.roomsample.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val text: String
)