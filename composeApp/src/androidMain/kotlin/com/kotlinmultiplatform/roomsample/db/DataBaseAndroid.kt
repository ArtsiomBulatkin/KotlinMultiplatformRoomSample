package com.kotlinmultiplatform.roomsample.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

fun getAndroidDataBase(ctx: Context): ChatDatabase {
    return getDatabaseBuilder(ctx).build()
}

private fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<ChatDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<ChatDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
}
