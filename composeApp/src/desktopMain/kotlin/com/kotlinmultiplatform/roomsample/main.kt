package com.kotlinmultiplatform.roomsample

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kotlinmultiplatform.roomsample.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "KotlinMultiplatformRoomSample",
        ) {
            App()
        }
    }
}