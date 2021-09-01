package com.filipau.domain.dto.post.user

data class UserDto(
    val address: AddressDto,
    val email: String = "",
    val id: Int = 0,
    val name: String = "",
    val phone: String = "",
    val username: String = "",
    val website: String = ""
)