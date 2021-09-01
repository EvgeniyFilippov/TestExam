package com.filipau.data.ext

import com.filipau.data.NetConstants.DEFAULT_INT
import com.filipau.data.NetConstants.DEFAULT_STRING
import com.filipau.data.model.post.PostItem
import com.filipau.domain.dto.post.PostItemDto

fun MutableList<PostItem>?.transformPostToDto(): MutableList<PostItemDto> {

        val listPostItemDto: MutableList<PostItemDto> = mutableListOf()

        this?.forEach { post ->
            val postItemDto = PostItemDto()
            postItemDto.id = post.id ?: DEFAULT_INT
            postItemDto.title = post.title ?: DEFAULT_STRING
            listPostItemDto.add(postItemDto)
        }
        return listPostItemDto
}
