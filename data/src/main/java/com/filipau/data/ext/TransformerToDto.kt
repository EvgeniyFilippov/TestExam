package com.filipau.data.ext

import com.filipau.data.NetConstants.DEFAULT_INT
import com.filipau.data.NetConstants.DEFAULT_STRING
import com.filipau.data.model.post.PostItem
import com.filipau.data.model.user.User
import com.filipau.domain.dto.post.PostItemDto
import com.filipau.domain.dto.user.AddressDto
import com.filipau.domain.dto.user.GeoDto
import com.filipau.domain.dto.user.UserDto

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

fun User?.transformUserToDto(): UserDto {

        val geoDto = GeoDto()
        val addressDto = AddressDto("", geoDto, "", "", "")
        val userDto = UserDto(addressDto)
        userDto.id = this?.id ?: DEFAULT_INT
        userDto.name = this?.name ?: DEFAULT_STRING
        userDto.username = this?.username ?: DEFAULT_STRING
        userDto.email = this?.email ?: DEFAULT_STRING
        userDto.phone = this?.phone ?: DEFAULT_STRING
        userDto.website = this?.website ?: DEFAULT_STRING
        userDto.address.city = this?.address?.city ?: DEFAULT_STRING
        userDto.address.geo.lat = this?.address?.geo?.lat ?: DEFAULT_STRING
        userDto.address.geo.lng = this?.address?.geo?.lng ?: DEFAULT_STRING

    return userDto
}
