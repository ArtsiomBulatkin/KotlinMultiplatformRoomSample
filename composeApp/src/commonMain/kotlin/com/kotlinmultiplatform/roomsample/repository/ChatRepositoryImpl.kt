package com.kotlinmultiplatform.roomsample.repository

import com.kotlinmultiplatform.roomsample.db.ChatDatabase
import com.kotlinmultiplatform.roomsample.db.MessageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ChatRepositoryImpl(private val db: ChatDatabase) : ChatRepository {

    private val messageDao = db.messageDao()

    override fun getMessages(): Flow<List<MessageEntity>> =
        messageDao.getMessages()

    override suspend fun insertMessage(message: MessageEntity) = withContext(Dispatchers.IO) {
        messageDao.insertMessage(message)
    }

    override suspend fun deleteMessage(message: MessageEntity) = withContext(Dispatchers.IO) {
        messageDao.deleteMessage(message)
    }
}