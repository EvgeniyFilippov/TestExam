package com.filipau.domain.dto.post

import java.io.Serializable

data class PostItemDto(
    var id: Int = 0,
    var title: String = ""
) : Serializable