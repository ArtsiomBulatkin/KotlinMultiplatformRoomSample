package com.kotlinmultiplatform.roomsample.repository

import com.kotlinmultiplatform.roomsample.db.MessageEntity
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getMessages(): Flow<List<MessageEntity>>
    suspend fun insertMessage(message: MessageEntity)
    suspend fun deleteMessage(message: MessageEntity)
}