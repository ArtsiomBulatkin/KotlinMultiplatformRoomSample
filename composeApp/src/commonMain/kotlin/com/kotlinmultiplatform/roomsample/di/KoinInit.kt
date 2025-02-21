package com.kotlinmultiplatform.roomsample.di

import com.kotlinmultiplatform.roomsample.AppViewModel
import com.kotlinmultiplatform.roomsample.repository.ChatRepository
import com.kotlinmultiplatform.roomsample.repository.ChatRepositoryImpl
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect fun platformModule(): Module

fun initKoin(appDeclaration: KoinAppDeclaration? = null) {
    startKoin {
        if (appDeclaration != null) appDeclaration()
        modules(
            platformModule(),
            appModules()
        )
    }
}

private fun appModules() = module {
    single<ChatRepository> { ChatRepositoryImpl(get()) }
    factory { AppViewModel(get()) }
}