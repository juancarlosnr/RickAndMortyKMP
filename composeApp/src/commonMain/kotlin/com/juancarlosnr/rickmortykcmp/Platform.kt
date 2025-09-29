package com.juancarlosnr.rickmortykcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform