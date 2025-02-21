package com.kotlinmultiplatform.roomsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinmultiplatform.roomsample.db.MessageEntity
import com.kotlinmultiplatform.roomsample.repository.ChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppViewModel(private val repository: ChatRepository) : ViewModel() {

    val chatsState: StateFlow<List<MessageEntity>> get() = _chatsState
    private val _chatsState: MutableStateFlow<List<MessageEntity>> = MutableStateFlow(emptyList())

    init {
        viewModelScope.launch {
            repository
                .getMessages()
                .collect { message ->
                    _chatsState.value = message
                }
        }
    }

    fun onMessageSend(msg: String) {
        viewModelScope.launch {
            runCatching { repository.insertMessage(MessageEntity(text = msg)) }
        }
    }

    fun onDeleteMessage(message: MessageEntity) {
        viewModelScope.launch {
            runCatching { repository.deleteMessage(message) }
        }
    }
}