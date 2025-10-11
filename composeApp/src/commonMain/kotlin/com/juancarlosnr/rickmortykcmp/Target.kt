package com.juancarlosnr.rickmortykcmp

expect fun getCurrentTarget(): Target

enum class Target {
    IOS,Android, Desktop
}

fun isDesktop() = getCurrentTarget() == Target.Desktop