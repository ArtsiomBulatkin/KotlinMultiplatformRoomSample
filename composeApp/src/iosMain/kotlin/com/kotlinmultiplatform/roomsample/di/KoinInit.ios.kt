package com.kotlinmultiplatform.roomsample.di

import com.kotlinmultiplatform.roomsample.db.ChatDatabase
import com.kotlinmultiplatform.roomsample.db.getIosDataBase
import org.koin.dsl.module

actual fun platformModule() = module {
    single<ChatDatabase> { getIosDataBase() }
}