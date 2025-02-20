package com.kotlinmultiplatform.roomsample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform