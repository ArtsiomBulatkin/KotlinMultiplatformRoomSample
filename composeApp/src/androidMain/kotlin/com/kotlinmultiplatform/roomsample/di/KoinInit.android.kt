package com.kotlinmultiplatform.roomsample.di

import com.kotlinmultiplatform.roomsample.db.ChatDatabase
import com.kotlinmultiplatform.roomsample.db.getAndroidDataBase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single<ChatDatabase> { getAndroidDataBase(get()) }
}