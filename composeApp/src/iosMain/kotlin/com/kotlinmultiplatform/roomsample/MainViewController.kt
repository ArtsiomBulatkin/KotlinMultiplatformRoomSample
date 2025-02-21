package com.kotlinmultiplatform.roomsample

import androidx.compose.ui.window.ComposeUIViewController
import com.kotlinmultiplatform.roomsample.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {
    App()
}