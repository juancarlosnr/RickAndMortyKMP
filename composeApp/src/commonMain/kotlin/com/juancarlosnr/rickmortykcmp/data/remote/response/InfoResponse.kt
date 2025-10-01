package com.juancarlosnr.rickmortykcmp.data.remote.response

import kotlinx.serialization.SerialName

data class InfoResponse(
    @SerialName("pages") val pages: Int,
    @SerialName("next") val next: String?,
    @SerialName("prev") val prev: String?
)
